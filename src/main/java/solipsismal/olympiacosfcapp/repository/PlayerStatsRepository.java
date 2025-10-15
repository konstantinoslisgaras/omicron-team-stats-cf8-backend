package solipsismal.olympiacosfcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import solipsismal.olympiacosfcapp.model.Player;
import solipsismal.olympiacosfcapp.model.PlayerStats;

import java.util.Optional;

public interface PlayerStatsRepository extends JpaRepository<PlayerStats, String>, JpaSpecificationExecutor<PlayerStats> {
    Optional<PlayerStats> findByPlayer(Player player);
}
