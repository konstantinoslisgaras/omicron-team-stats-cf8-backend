package solipsismal.olympiacosfcapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import solipsismal.olympiacosfcapp.core.enums.Result;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "player_stats")
public class PlayerStats {

    @Id
    @Column(length = 12, unique = true, nullable = false)
    private String id;

    @Column(length = 4, nullable = false)
    private Integer goals = 0;

    @Column(length = 4, nullable = false)
    private Integer assists = 0;

    @Column(name = "yellow_cards", length = 4, nullable = false)
    private Integer yellowCards = 0;

    @Column(name = "red_cards", length = 4, nullable = false)
    private Integer redCards = 0;

    @Column(name = "goals_conceded", length = 4, nullable = false)
    private Integer goalsConceded = 0;

    @Column(name = "clean_sheets", length = 4, nullable = false)
    private Integer cleanSheets = 0;

    @Column(name ="minutes_played", length = 3, nullable = false)
    private Integer minutesPlayed = 0;

    @Column(name = "matches_played", length = 4, nullable = false)
    private Integer matchesPlayed = 0;

    @Column(length = 4, nullable = false)
    private Integer wins = 0;

    @Column(length = 4, nullable = false)
    private Integer draws = 0;

    @Column(length = 4, nullable = false)
    private Integer losses = 0;

    @OneToOne
    private Player player;

    public PlayerStats(String id, Player player) {
        this.id = id;
        this.player = player;
    }

    public void addMatchStats(PlayerMatch match, Result result) {
        this.goals += match.getGoals();
        this.assists += match.getAssists();
        this.yellowCards += match.getYellowCards();
        this.redCards += match.getRedCards();
        this.goalsConceded += match.getGoalsConceded();
        this.cleanSheets += match.getCleanSheets();
        ++this.matchesPlayed;
        this.minutesPlayed += match.getMinutesPlayed();
        addWinDrawLossStats(result);
    }

    private void addWinDrawLossStats(Result result) {
        switch (result) {
            case WIN -> ++this.wins;
            case DRAW -> ++this.draws;
            case LOSS -> ++this.losses;
        }
    }
}
