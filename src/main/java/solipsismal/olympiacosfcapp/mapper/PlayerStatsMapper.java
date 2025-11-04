package solipsismal.olympiacosfcapp.mapper;

import solipsismal.olympiacosfcapp.dto.PlayerDTO;
import solipsismal.olympiacosfcapp.dto.PlayerStatsDTO;
import solipsismal.olympiacosfcapp.model.Player;
import solipsismal.olympiacosfcapp.model.PlayerStats;

public class PlayerStatsMapper {

    public static PlayerStatsDTO toDTO(PlayerStats playerStats) {
        if (playerStats == null) return null;

        Player player = playerStats.getPlayer();
        PlayerDTO playerDTO = new PlayerDTO(player);
        playerDTO.setId(player.getId());
        playerDTO.setLastname(player.getLastname());
        playerDTO.setFirstname(player.getFirstname());
        playerDTO.setBirthYear(player.getBirthYear());
        playerDTO.setNationality(player.getNationality());
        playerDTO.setPosition(player.getPosition().name());
        playerDTO.setShirtNumber(player.getShirtNumber());

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
                playerStats.getMinutesPlayed(),
                playerStats.getMatchesPlayed(),
                playerStats.getWins(),
                playerStats.getDraws(),
                playerStats.getLosses()
        );
    }
}
