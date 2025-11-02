package solipsismal.olympiacosfcapp.dto;

import lombok.Getter;
import lombok.Setter;
import solipsismal.olympiacosfcapp.config.PlayerMatchDataLoader;
import solipsismal.olympiacosfcapp.model.PlayerMatch;

import java.util.List;

@Getter
@Setter
public class PlayerMatchDTO {
    private String id;
    private String player;
    private Integer goals;
    private Integer assists;
    private Integer yellowCards;
    private Integer redCards;
    private Integer goalsConceded;
    private Integer minutesPlayed;

    public PlayerMatchDTO(PlayerMatch playerMatch) {
        this.id = playerMatch.getId();
        this.player = playerMatch.getPlayer().getLastname();
        this.goals = playerMatch.getGoals();
        this.assists = playerMatch.getAssists();
        this.yellowCards = playerMatch.getYellowCards();
        this.redCards = playerMatch.getRedCards();
        this.goalsConceded = playerMatch.getGoalsConceded();
        this.minutesPlayed = playerMatch.getMinutesPlayed();
    }
}