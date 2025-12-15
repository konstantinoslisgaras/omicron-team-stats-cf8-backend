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
import solipsismal.olympiacosfcapp.core.exceptions.TeamStatsNotFoundException;
import solipsismal.olympiacosfcapp.dto.TeamStatsDTO;
import solipsismal.olympiacosfcapp.model.TeamStats;
import solipsismal.olympiacosfcapp.repository.TeamStatsRepository;

@RestController
@RequestMapping("api/statistics")
@RequiredArgsConstructor
public class TeamStatsController {

    private final TeamStatsRepository teamStatsRepository;

    @GetMapping("/team/{teamStatsId}")
    @Operation(
            summary = "Get team stats.",
            description = "Retrieves the team stats by id."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Team stats found",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TeamStatsDTO.class))
    )
    @ApiResponse(
            responseCode = "400",
            description = "Invalid team stats ID"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Team stats not Found"
    )
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content
    )
    public TeamStatsDTO getTeamStatsById(@PathVariable String teamStatsId) throws TeamStatsNotFoundException {
        TeamStats teamStats = teamStatsRepository.findById(teamStatsId).orElseThrow(TeamStatsNotFoundException::new);
        return new TeamStatsDTO(teamStats);
    }
}