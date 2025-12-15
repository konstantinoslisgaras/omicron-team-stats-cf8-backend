package solipsismal.olympiacosfcapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "team_stats")
public class TeamStats {

    @Id
    @Column(length = 10, unique = true, nullable = false)
    private String id;

    @Column(length = 4, nullable = false)
    private Integer goals = 0;

    @Column(length = 4, nullable = false)
    private Integer assists = 0;

    @Column(name = "goals_conceded", length = 4, nullable = false)
    private Integer goalsConceded = 0;

    @Column(name = "yellow_cards", length = 4, nullable = false)
    private Integer yellowCards = 0;

    @Column(name = "red_cards", length = 4, nullable = false)
    private Integer redCards = 0;

    @Column(length = 4, nullable = false)
    private Integer wins = 0;

    @Column(length = 4, nullable = false)
    private Integer draws = 0;

    @Column(length = 4, nullable = false)
    private Integer losses = 0;

    @Column(name = "total_matches", length = 4, nullable = false)
    private Integer totalMatches = 0;

    public TeamStats(String id) {
        this.id = id;
    }

    public TeamStats(String id, Integer goals, Integer assists, Integer goalsConceded, Integer yellowCards, Integer redCards) {
        this.id = id;
        this.goals = goals;
        this.assists = assists;
        this.goalsConceded = goalsConceded;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        addWinDrawLossStats(goals, goalsConceded);
        ++this.totalMatches;
    }

    public void addStats(TeamStats match) {
        this.goals += match.getGoals();
        this.assists += match.getAssists();
        this.goalsConceded += match.getGoalsConceded();
        this.yellowCards += match.getYellowCards();
        this.redCards += match.getRedCards();
        this.wins += match.getWins();
        this.draws += match.getDraws();
        this.losses += match.getLosses();
        this.totalMatches += match.getTotalMatches();
    }

    public void addWinDrawLossStats(int goals, int goalsConceded) {
        if (goals > goalsConceded) {
            this.wins++;
        } else if (goals == goalsConceded) {
            this.draws++;
        } else {
            this.losses++;
        }
    }
}