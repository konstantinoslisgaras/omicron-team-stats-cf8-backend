package solipsismal.olympiacosfcapp.dto;

import lombok.Getter;
import lombok.Setter;
import solipsismal.olympiacosfcapp.model.Match;

import java.util.List;

@Getter
@Setter
public class MatchFullDTO extends MatchDetailedDTO {

    private String coachName;
    private List<PlayerMatchDTO> playerMatches;
    private TeamStatsDTO teamStatsDTO;

    public MatchFullDTO(Match match, List<PlayerMatchDTO> playerMatches, TeamStatsDTO teamStatsDTO) {
        super(match);
        this.coachName = match.getCoach().getDetailedBio().getFullname();
        this.playerMatches = playerMatches;
        this.teamStatsDTO = teamStatsDTO;
    }
}
