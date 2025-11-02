package solipsismal.olympiacosfcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import solipsismal.olympiacosfcapp.model.Coach;
import solipsismal.olympiacosfcapp.model.PlayerMatch;

import java.util.List;

public interface PlayerMatchRepository extends JpaRepository<PlayerMatch, String>, JpaSpecificationExecutor<PlayerMatch> {
    List<PlayerMatch> findByMatchId(String matchId);
}
