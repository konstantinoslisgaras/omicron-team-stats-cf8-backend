package solipsismal.olympiacosfcapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solipsismal.olympiacosfcapp.core.exceptions.MatchNotFoundException;
import solipsismal.olympiacosfcapp.core.exceptions.PlayerMatchNotFoundException;
import solipsismal.olympiacosfcapp.dto.MatchFullDTO;
import solipsismal.olympiacosfcapp.dto.PlayerMatchDTO;
import solipsismal.olympiacosfcapp.model.Match;
import solipsismal.olympiacosfcapp.model.PlayerMatch;
import solipsismal.olympiacosfcapp.repository.MatchRepository;
import solipsismal.olympiacosfcapp.repository.PlayerMatchRepository;

import java.util.List;

@RestController
@RequestMapping("api/matches/detailed")
@RequiredArgsConstructor
public class PlayerMatchController {

    private final MatchRepository matchRepository;
    private final PlayerMatchRepository playerMatchRepository;

    @GetMapping("/{matchId}")
    public MatchFullDTO getMatchFull(@PathVariable String matchId) throws MatchNotFoundException, PlayerMatchNotFoundException {
        Match match = matchRepository.findById(matchId).orElseThrow(MatchNotFoundException::new);

        List<PlayerMatch> playersMatches = playerMatchRepository.findByMatchId(matchId);
        if (playersMatches.isEmpty()) throw new PlayerMatchNotFoundException(matchId);

        List<PlayerMatchDTO> playerMatchDTOS = playersMatches.stream()
                .map(PlayerMatchDTO::new)
                .toList();

        return new MatchFullDTO(match, playerMatchDTOS);
    }
}