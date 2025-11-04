package solipsismal.olympiacosfcapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerStatsDTO {
    private String playerId;
    private String name;
    private String position;
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;
    private int goalsConceded;
    private int minutesPlayed;
    private int matchesPlayed;
    private int wins;
    private int draws;
    private int losses;

    public PlayerStatsDTO(String playerId, String lastname, String firstname, String position,
                          int goals, int assists, int yellowCards, int redCards, int goalsConceded, int minutesPlayed, int matchesPlayed,
                          int wins, int draws, int losses) {
        this.playerId = playerId;
        this.name = getConcatenatedName(lastname, firstname);
        this.position = position.replace("_", " ");
        this.goals = goals;
        this.assists = assists;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.goalsConceded = goalsConceded;
        this.minutesPlayed = minutesPlayed;
        this.matchesPlayed = matchesPlayed;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }

    private String getConcatenatedName(String lastname, String firstname) {
        if (firstname == null || firstname.isEmpty()) return lastname;
        return lastname + " " + firstname.charAt(0) + ".";
    }
}