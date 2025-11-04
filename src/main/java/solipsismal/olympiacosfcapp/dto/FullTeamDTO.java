package solipsismal.olympiacosfcapp.dto;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class FullTeamDTO {

    private List<PlayerDTO> players;
    private CoachDTO coach;

    public FullTeamDTO(List<PlayerDTO> players, CoachDTO coach) {
        this.players = players;
        this.coach = coach;
    }
}