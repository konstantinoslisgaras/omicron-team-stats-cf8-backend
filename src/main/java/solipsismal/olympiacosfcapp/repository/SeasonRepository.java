package solipsismal.olympiacosfcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import solipsismal.olympiacosfcapp.model.Season;

public interface SeasonRepository extends JpaRepository<Season, String>, JpaSpecificationExecutor<Season> {
}