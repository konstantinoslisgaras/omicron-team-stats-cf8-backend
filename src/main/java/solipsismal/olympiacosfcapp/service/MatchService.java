package solipsismal.olympiacosfcapp.service;

import org.springframework.stereotype.Service;
import solipsismal.olympiacosfcapp.dto.MatchBasicDTO;
import solipsismal.olympiacosfcapp.repository.MatchRepository;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MatchService implements IMatchService{

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Optional<MatchBasicDTO> getPreviousMatch() {
        LocalDateTime now = LocalDateTime.now();
        return matchRepository.findPreviousMatch(now)
                .map(MatchBasicDTO::new);
    }

    @Override
    public Optional<MatchBasicDTO> getNextMatch() {
        LocalDateTime now = LocalDateTime.now();
        return matchRepository.findNextMatch(now)
                .map(MatchBasicDTO::new);
    }
}