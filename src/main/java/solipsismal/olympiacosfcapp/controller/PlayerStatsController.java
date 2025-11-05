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
import solipsismal.olympiacosfcapp.core.exceptions.PlayerStatsNotFoundException;
import solipsismal.olympiacosfcapp.dto.PlayerStatsDTO;
import solipsismal.olympiacosfcapp.mapper.PlayerStatsMapper;
import solipsismal.olympiacosfcapp.model.PlayerStats;
import solipsismal.olympiacosfcapp.repository.PlayerStatsRepository;

@RestController
@RequestMapping("/api/statistics")
@RequiredArgsConstructor
public class PlayerStatsController {

    private final PlayerStatsRepository playerStatsRepository;

    @GetMapping("/players/{playerStatsId}")
    @Operation(
            summary = "Get player stats by id.",
            description = "Retrieves a player's stats by their id."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Player stats found",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PlayerStatsDTO.class))
    )
    @ApiResponse(responseCode = "404", description = "Player stats not Found")
    public PlayerStatsDTO getPlayerStatsById(@PathVariable String playerStatsId) throws PlayerStatsNotFoundException {
        PlayerStats playerStats = playerStatsRepository.findById(playerStatsId).orElseThrow(PlayerStatsNotFoundException::new);
        return PlayerStatsMapper.toDTO(playerStats);
    }
}