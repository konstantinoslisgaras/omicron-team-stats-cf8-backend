package solipsismal.olympiacosfcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import solipsismal.olympiacosfcapp.model.Player;
import solipsismal.olympiacosfcapp.model.PlayerStats;

import java.util.List;
import java.util.Optional;

public interface PlayerStatsRepository extends JpaRepository<PlayerStats, String>, JpaSpecificationExecutor<PlayerStats> {
    Optional<PlayerStats> findByPlayer(Player player);

    // Goals
    Optional<PlayerStats> findFirstByOrderByGoalsDesc();
    List<PlayerStats> findTop5ByOrderByGoalsDesc();

    // Assists
    Optional<PlayerStats> findFirstByOrderByAssistsDesc();
    List<PlayerStats> findTop5ByOrderByAssistsDesc();

    // Yellow cards
    Optional<PlayerStats> findFirstByOrderByYellowCardsDesc();
    List<PlayerStats> findTop5ByOrderByYellowCardsDesc();

    // Red cards
    Optional<PlayerStats> findFirstByOrderByRedCardsDesc();
    List<PlayerStats> findTop5ByOrderByRedCardsDesc();

    // Minutes
    Optional<PlayerStats> findFirstByOrderByMinutesPlayedDesc();
    List<PlayerStats> findTop5ByOrderByMinutesPlayedDesc();

    // Appearances
    Optional<PlayerStats> findFirstByOrderByMatchesPlayedDesc();
    List<PlayerStats> findTop5ByOrderByMatchesPlayedDesc();

    // Wins
    Optional<PlayerStats> findFirstByOrderByWinsDesc();
}
