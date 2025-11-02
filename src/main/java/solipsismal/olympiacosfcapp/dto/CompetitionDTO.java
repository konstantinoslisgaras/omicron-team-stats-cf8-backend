package solipsismal.olympiacosfcapp.dto;

import lombok.Getter;
import lombok.Setter;
import solipsismal.olympiacosfcapp.model.Competition;

@Getter
@Setter
public class CompetitionDTO {
    private String id;
    private String competitionName;
    private Integer competitionPosition;
    private Integer competitionPoints;
    private String competitionInfo;
    private boolean isParticipating;

    public CompetitionDTO(Competition competition) {
        this.id = competition.getId();
        this.competitionName = competition.getCompetitionName();
        this.competitionPosition = competition.getCompetitionPosition();
        this.competitionPoints = competition.getCompetitionPoints();
        this.competitionInfo = competition.getCompetitionInfo();
        this.isParticipating = competition.isParticipating();
    }
}
