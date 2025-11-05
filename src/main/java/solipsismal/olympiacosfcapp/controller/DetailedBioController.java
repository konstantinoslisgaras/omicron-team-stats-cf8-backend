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
import solipsismal.olympiacosfcapp.core.exceptions.DetailedBioNotFoundException;
import solipsismal.olympiacosfcapp.dto.DetailedBioDTO;
import solipsismal.olympiacosfcapp.model.Coach;
import solipsismal.olympiacosfcapp.model.DetailedBio;
import solipsismal.olympiacosfcapp.model.Player;
import solipsismal.olympiacosfcapp.repository.CoachRepository;
import solipsismal.olympiacosfcapp.repository.DetailedBioRepository;
import solipsismal.olympiacosfcapp.repository.PlayerRepository;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DetailedBioController {

    private final PlayerRepository playerRepository;
    private final CoachRepository coachRepository;
    private final DetailedBioRepository detailedBioRepository;

    @GetMapping("/players/{playerId}/{detailedBioId}")
    @Operation(
            summary = "Get a player bio by id.",
            description = "Retrieves a biography by id."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Biography found",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = DetailedBioDTO.class))
    )
    @ApiResponse(responseCode = "404", description = "Player biography not Found")
    public DetailedBioDTO getPlayerDetailedBioById(@PathVariable String playerId, @PathVariable String detailedBioId) throws DetailedBioNotFoundException {
        Player player = playerRepository.findById(playerId).orElseThrow(DetailedBioNotFoundException::new);

        DetailedBio detailedBio = player.getDetailedBio();
        if (detailedBio == null || !detailedBio.getId().equals(detailedBioId)) {
            throw new DetailedBioNotFoundException(playerId, detailedBioId);
        }

        return new DetailedBioDTO(detailedBio);
    }

    @GetMapping("/coach/{coachId}/{detailedBioId}")
    @Operation(
            summary = "Get a coach's bio by id.",
            description = "Retrieves a biography by id."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Biography found",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = DetailedBioDTO.class))
    )
    @ApiResponse(responseCode = "404", description = "Coach biography not Found")
    public DetailedBioDTO getCoachDetailedBioById(@PathVariable String coachId, @PathVariable String detailedBioId) throws DetailedBioNotFoundException {
        Coach coach = coachRepository.findById(coachId).orElseThrow(DetailedBioNotFoundException::new);

        DetailedBio detailedBio = coach.getDetailedBio();
        if (detailedBio == null || !detailedBio.getId().equals(detailedBioId)) {
            throw new DetailedBioNotFoundException(coachId, detailedBioId);
        }

        return new DetailedBioDTO(detailedBio);
    }
}