package solipsismal.olympiacosfcapp.service;

import org.springframework.stereotype.Service;
import solipsismal.olympiacosfcapp.dto.CompetitionDTO;
import solipsismal.olympiacosfcapp.repository.CompetitionRepository;
import java.util.List;

@Service
public class CompetitionService implements ICompetitionService{

    private final CompetitionRepository competitionRepository;

    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public List<CompetitionDTO> findAll() {
        return competitionRepository.findAllByOrderByIdAsc()
                .stream()
                .map(CompetitionDTO::new)
                .toList();
    }

    @Override
    public List<CompetitionDTO> findActive() {
        return competitionRepository.findByIsParticipatingTrueOrderByIdAsc()
                .stream()
                .map(CompetitionDTO::new)
                .toList();
    }
}
