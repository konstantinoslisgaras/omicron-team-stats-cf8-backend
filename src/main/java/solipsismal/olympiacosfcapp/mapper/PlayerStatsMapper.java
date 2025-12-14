package solipsismal.olympiacosfcapp.mapper;

import solipsismal.olympiacosfcapp.dto.PlayerStatsDTO;
import solipsismal.olympiacosfcapp.model.PlayerStats;

public class PlayerStatsMapper {

    public static PlayerStatsDTO toDTO(PlayerStats playerStats) {
        if (playerStats == null || playerStats.getPlayer() == null) return null;

        var player = playerStats.getPlayer();

        return new PlayerStatsDTO(
                player.getId(),
                player.getLastname(),
                player.getFirstname(),
                player.getPosition().name(),
                playerStats.getGoals(),
                playerStats.getAssists(),
                playerStats.getYellowCards(),
                playerStats.getRedCards(),
                playerStats.getGoalsConceded(),
                playerStats.getCleanSheets(),
                playerStats.getMinutesPlayed(),
                playerStats.getMatchesPlayed(),
                playerStats.getWins(),
                playerStats.getDraws(),
                playerStats.getLosses()
        );
    }
}