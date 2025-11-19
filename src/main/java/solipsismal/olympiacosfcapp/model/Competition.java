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
@Table(name = "competitions")
public class Competition {

    @Id
    @Column(length = 10, unique = true, nullable = false)
    private String id;

    @Column(name = "competition_name", length = 50, unique = true, nullable = false)
    private String competitionName;

    @Column(name = "olympiacos_trophies")
    private Integer olympiacosTrophies;

    @Column(name = "competition_position", length = 2)
    private Integer competitionPosition = 1;

    @Column(name = "competition_points", length = 2)
    private Integer competitionPoints = 0;

    @Column(name = "competition_info", length = 1000)
    private String competitionInfo;

    @Column(name = "is_participating")
    private boolean isParticipating = false;

    public Competition(String id, String competitionName, Integer olympiacosTrophies, String competitionInfo) {
        this.id = id;
        this.competitionName = competitionName;
        this.olympiacosTrophies = olympiacosTrophies;
        this.competitionInfo = competitionInfo;
        this.isParticipating = true;
    }

    public Competition(String id, String competitionName, Integer olympiacosTrophies, String competitionInfo, boolean isParticipating) {
        this.id = id;
        this.competitionName = competitionName;
        this.olympiacosTrophies = olympiacosTrophies;
        this.competitionInfo = competitionInfo;
        this.isParticipating = isParticipating;
    }

    public void add3() {
        this.competitionPoints += 3;
    }

    public void add1() {
        this.competitionPoints += 1;
    }

    public void addTrophy() {
        this.olympiacosTrophies++;
    }

    public Competition setCompetitionPosition(int position) {
        this.competitionPosition = position;
        return this;
    }
}
