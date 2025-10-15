package solipsismal.olympiacosfcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import solipsismal.olympiacosfcapp.model.Coach;
import solipsismal.olympiacosfcapp.model.Match;

public interface MatchRepository extends JpaRepository<Match, String>, JpaSpecificationExecutor<Match> {
}
