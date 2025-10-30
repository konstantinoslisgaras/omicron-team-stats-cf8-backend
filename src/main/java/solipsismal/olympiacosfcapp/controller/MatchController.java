package solipsismal.olympiacosfcapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solipsismal.olympiacosfcapp.core.exceptions.MatchNotFoundException;
import solipsismal.olympiacosfcapp.dto.MatchDetailedDTO;
import solipsismal.olympiacosfcapp.dto.MatchBasicDTO;
import solipsismal.olympiacosfcapp.model.Match;
import solipsismal.olympiacosfcapp.repository.MatchRepository;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchRepository matchRepository;

    @GetMapping("/schedule")
    public List<MatchBasicDTO> getMatchesBasic() {
        return matchRepository.findAllByOrderByMatchNumber()
                .stream()
                .map(MatchBasicDTO::new)
                .toList();
    }

    @GetMapping("/detailed")
    public List<MatchDetailedDTO> getMatchesDetailed() {
        return matchRepository.findAllByOrderByMatchNumber()
                .stream()
                .map(MatchDetailedDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public MatchDetailedDTO getMatchById(@PathVariable String id) throws MatchNotFoundException {
        Match match = matchRepository.findById(id).orElseThrow(MatchNotFoundException::new);
        return new MatchDetailedDTO(match);
    }
}