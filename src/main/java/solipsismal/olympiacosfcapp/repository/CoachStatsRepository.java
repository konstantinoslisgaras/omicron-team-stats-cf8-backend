package solipsismal.olympiacosfcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import solipsismal.olympiacosfcapp.model.CoachStats;

public interface CoachStatsRepository extends JpaRepository<CoachStats, String>, JpaSpecificationExecutor<CoachStats> {
}
