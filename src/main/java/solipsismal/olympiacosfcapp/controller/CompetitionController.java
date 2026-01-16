package solipsismal.olympiacosfcapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solipsismal.olympiacosfcapp.core.exceptions.CompetitionNotFoundException;
import solipsismal.olympiacosfcapp.dto.CompetitionDTO;
import solipsismal.olympiacosfcapp.dto.ErrorResponseDTO;
import solipsismal.olympiacosfcapp.dto.OlympiacosDTO;
import solipsismal.olympiacosfcapp.model.Competition;
import solipsismal.olympiacosfcapp.repository.CompetitionRepository;
import solipsismal.olympiacosfcapp.repository.OlympiacosRepository;

import java.util.List;

@RestController
@RequestMapping("/api/competitions")
@RequiredArgsConstructor
public class CompetitionController {

    private final CompetitionRepository competitionRepository;

    @GetMapping
    @Operation(
            summary = "Get all competitions",
            description = "Retrieves information about all competitions Olympiacos participates in."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Competitions retrieved successfully",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CompetitionDTO.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "No competitions found",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDTO.class)
            )
    )
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDTO.class)
            )
    )
    public List<CompetitionDTO> getCompetitionsInfo() throws CompetitionNotFoundException {
        return competitionRepository.findAll()
                .stream()
                .map(CompetitionDTO::new)
                .toList();
    }
}