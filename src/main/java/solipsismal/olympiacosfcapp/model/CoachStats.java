package solipsismal.olympiacosfcapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "coach_stats")
public class CoachStats {

    @Id
    @Column(length = 12, unique = true, nullable = false)
    private String id;

    @Column(length = 4, nullable = false)
    private Integer wins = 0;

    @Column(length = 4, nullable = false)
    private Integer draws = 0;

    @Column(length = 4, nullable = false)
    private Integer losses = 0;

    @Column(length = 4, nullable = false)
    private Integer goals = 0;

    @Column(name = "goals_conceded", length = 4, nullable = false)
    private Integer goalsConceded = 0;

    @Column(name = "matches_managed", length = 4, nullable = false)
    private Integer matchesManaged = 0;

    public CoachStats(String id, Integer goals, Integer goalsConceded) {
        this.id = id;
        this.goals = goals;
        this.goalsConceded = goalsConceded;
    }

    public CoachStats(String id, Integer wins, Integer draws, Integer losses, Integer goals, Integer goalsConceded, Integer matchesManaged) {
        this.id = id;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
        this.goals = goals;
        this.goalsConceded = goalsConceded;
        this.matchesManaged = matchesManaged;
    }

    public void addCoachMatchStats(int goals, int goalsConceded) {
        this.wins += (goals > goalsConceded) ? 1 : 0;
        this.draws += (goals == goalsConceded) ? 1 : 0;
        this.losses += (goals < goalsConceded) ? 1 : 0;
        this.goals += goals;
        this.goalsConceded += goalsConceded;
        ++matchesManaged;
    }
}
