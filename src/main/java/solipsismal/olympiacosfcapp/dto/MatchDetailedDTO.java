package solipsismal.olympiacosfcapp.dto;

import lombok.Getter;
import lombok.Setter;
import solipsismal.olympiacosfcapp.model.*;

@Getter
@Setter
public class MatchDetailedDTO extends MatchBasicDTO{
    private String day;
    private String competition;
    private Integer matchNumber;
    private String description;
    private TeamStatsDTO teamStatsDTO;
    private String season;

    public MatchDetailedDTO(Match match) {
        super(match);
        this.day = match.getDay().toString();
        this.competition = match.getCompetition().getCompetitionName();
        this.matchNumber = match.getMatchNumber();
        this.description = match.getDescription();
        this.teamStatsDTO = new TeamStatsDTO(match.getTeamStats());
        this.season = match.getSeason().getSeasonName();
    }
}