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
@Table(name = "coach_stats")
public class CoachStats {

    @Id
    @Column(length = 10, unique = true, nullable = false)
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

    public void addCoachMatchStats(CoachStats coachStats) {
        this.wins += (coachStats.goals > coachStats.goalsConceded) ? 1 : 0;
        this.draws += (coachStats.goals.equals(coachStats.goalsConceded)) ? 1 : 0;
        this.losses += (coachStats.goals < coachStats.goalsConceded) ? 1 : 0;
        this.goals += coachStats.goals;
        this.goalsConceded += coachStats.goalsConceded;
        ++matchesManaged;
    }
}
