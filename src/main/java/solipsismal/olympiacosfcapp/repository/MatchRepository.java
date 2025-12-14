package solipsismal.olympiacosfcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import solipsismal.olympiacosfcapp.model.Match;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, String>, JpaSpecificationExecutor<Match> {
    List<Match> findAllByOrderByMatchNumber();
    List<Match> findAllByOrderByMatchNumberDesc();

//    // Previous match finder MySQL
//    @Query("SELECT m FROM Match m WHERE " +
//            "FUNCTION('timestamp', m.date, m.time) < :now " +
//            "ORDER BY m.date DESC, m.time DESC")
//    Optional<Match> findPreviousMatch(@Param("now") LocalDateTime dateTime);
//
//    // Next match finder MySQL
//    @Query("SELECT m FROM Match m WHERE " +
//            "FUNCTION('timestamp', m.date, m.time) > :now " +
//            "ORDER BY m.date ASC, m.time ASC")
//    Optional<Match> findNextMatch(@Param("now") LocalDateTime dateTime);

    // Previous match finder PostgreSQL
    @Query(value = "SELECT * FROM matches m WHERE m.date + m.time < :now ORDER BY m.date DESC, m.time DESC LIMIT 1", nativeQuery = true)
    Optional<Match> findPreviousMatch(@Param("now") LocalDateTime dateTime);

    // Next match finder PostgreSQL
    @Query(value = "SELECT * FROM matches m WHERE m.date + m.time > :now ORDER BY m.date ASC, m.time ASC LIMIT 1", nativeQuery = true)
    Optional<Match> findNextMatch(@Param("now") LocalDateTime dateTime);
}