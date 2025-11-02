package solipsismal.olympiacosfcapp.service;

import org.springframework.stereotype.Service;
import solipsismal.olympiacosfcapp.dto.TeamStatsDTO;
import solipsismal.olympiacosfcapp.repository.TeamStatsRepository;
import java.util.List;

@Service
public class TeamStatsService implements ITeamStatsService{

    private final TeamStatsRepository teamStatsRepository;

    public TeamStatsService(TeamStatsRepository teamStatsRepository) {
        this.teamStatsRepository = teamStatsRepository;
    }

    @Override
    public List<TeamStatsDTO> findById(String id) {
        return teamStatsRepository.findById(id)
                .stream()
                .map(TeamStatsDTO::new)
                .toList();
    }
}
