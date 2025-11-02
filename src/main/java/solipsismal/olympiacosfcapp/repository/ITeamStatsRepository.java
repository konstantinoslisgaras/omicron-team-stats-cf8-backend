package solipsismal.olympiacosfcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import solipsismal.olympiacosfcapp.model.TeamStats;

public interface ITeamStatsRepository extends JpaRepository<TeamStats, String>, JpaSpecificationExecutor<TeamStats> {
}
