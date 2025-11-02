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

    @Column(name = "competition_position", length = 2)
    private Integer competitionPosition = 1;

    @Column(name = "competition_points", length = 2)
    private Integer competitionPoints = 0;

    @Column(name = "competition_info", length = 1000)
    private String competitionInfo;

    @Column(name = "is_eliminated")
    private boolean isParticipating = false;

    public Competition(String id, String competitionName, String competitionInfo) {
        this.id = id;
        this.competitionName = competitionName;
        this.competitionInfo = competitionInfo;
        isParticipating = true;
    }

    public void add3() {
        this.competitionPoints += 3;
    }

    public void add1() {
        this.competitionPoints += 1;
    }

    public Competition setCompetitionPosition(int position) {
        this.competitionPosition = position;
        return this;
    }
}
