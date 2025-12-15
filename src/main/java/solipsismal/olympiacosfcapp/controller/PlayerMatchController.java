package solipsismal.olympiacosfcapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solipsismal.olympiacosfcapp.core.exceptions.MatchNotFoundException;
import solipsismal.olympiacosfcapp.core.exceptions.PlayerMatchNotFoundException;
import solipsismal.olympiacosfcapp.dto.MatchFullDTO;
import solipsismal.olympiacosfcapp.dto.PlayerMatchDTO;
import solipsismal.olympiacosfcapp.dto.TeamStatsDTO;
import solipsismal.olympiacosfcapp.model.Coach;
import solipsismal.olympiacosfcapp.model.Match;
import solipsismal.olympiacosfcapp.model.PlayerMatch;
import solipsismal.olympiacosfcapp.repository.MatchRepository;
import solipsismal.olympiacosfcapp.repository.PlayerMatchRepository;
import solipsismal.olympiacosfcapp.repository.PlayerRepository;

import java.util.List;

@RestController
@RequestMapping("api/matches/detailed")
@RequiredArgsConstructor
public class PlayerMatchController {

    private final MatchRepository matchRepository;
    private final PlayerMatchRepository playerMatchRepository;
    private final PlayerRepository playerRepository;

    @GetMapping("/{matchId}")
    @Operation(
            summary = "Get full match details",
            description = "Retrieves complete match details including result, player performances and team statistics"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Match details retrieved successfully",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MatchFullDTO.class))
    )
    @ApiResponse(
            responseCode = "400",
            description = "Invalid match ID",
            content = @Content
    )
    @ApiResponse(
            responseCode = "404",
            description = "Match data not found",
            content = @Content
    )
    public MatchFullDTO getMatchFull(@PathVariable String matchId) throws MatchNotFoundException, PlayerMatchNotFoundException {
        Match match = matchRepository.findById(matchId).orElseThrow(MatchNotFoundException::new);

        List<PlayerMatch> playersMatches = playerMatchRepository.findByMatchId(matchId);
        if (playersMatches.isEmpty()) throw new PlayerMatchNotFoundException(matchId);

        List<PlayerMatchDTO> playerMatchDTOS = playersMatches.stream()
                .map(PlayerMatchDTO::new)
                .toList();

        TeamStatsDTO teamStatsDTO = new TeamStatsDTO(match.getTeamStats());

        return new MatchFullDTO(match, playerMatchDTOS, teamStatsDTO);
    }
}