package solipsismal.olympiacosfcapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solipsismal.olympiacosfcapp.dto.CoachDTO;
import solipsismal.olympiacosfcapp.dto.FullTeamDTO;
import solipsismal.olympiacosfcapp.dto.PlayerDTO;
import solipsismal.olympiacosfcapp.model.Coach;
import solipsismal.olympiacosfcapp.repository.CoachRepository;
import solipsismal.olympiacosfcapp.repository.PlayerRepository;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class FullTeamController {

    private final PlayerRepository playerRepository;
    private final CoachRepository coachRepository;

    @GetMapping("/fullteam")
    @Operation(
            summary = "Get the full roster.",
            description = "Retrieves the complete team roster including players and coach"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Team roster found",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = FullTeamDTO.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Team roster not found",
            content = @Content
    )
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content
    )
    public FullTeamDTO getSquad() {
        List<PlayerDTO> players = playerRepository.findAllByOrderByShirtNumberAsc()
                .stream()
                .map(PlayerDTO::new)
                .toList();

        Coach coach = coachRepository.findByPlaysForOlympiacosTrue().orElseThrow(() -> new EntityNotFoundException("Coach not found"));
        CoachDTO coachDTO = new CoachDTO(coach);

        return new FullTeamDTO(players, coachDTO);
    }
}