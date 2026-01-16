package solipsismal.olympiacosfcapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solipsismal.olympiacosfcapp.dto.ErrorResponseDTO;
import solipsismal.olympiacosfcapp.dto.MatchDetailedDTO;
import solipsismal.olympiacosfcapp.dto.MatchBasicDTO;
import solipsismal.olympiacosfcapp.repository.MatchRepository;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchRepository matchRepository;

    @GetMapping("/schedule")
    @Operation(
            summary = "Get past and next fixtures.",
            description = "Retrieves basic match information, upcoming and past, ordered by match number (descending)"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Match schedule retrieved successfully",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MatchBasicDTO.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "No basic matches found",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDTO.class)
            )
    )
    public List<MatchBasicDTO> getMatchesBasic() {
        return matchRepository.findAllByOrderByMatchNumberDesc()
                .stream()
                .map(MatchBasicDTO::new)
                .toList();
    }

    @GetMapping("/detailed")
    @Operation(
            summary = "Get detailed matches list",
            description = "Retrieves detailed match information ordered by match number (ascending)"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Detailed match list retrieved successfully",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MatchDetailedDTO.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "No detailed matches found",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDTO.class)
            )
    )
    public List<MatchDetailedDTO> getMatchesDetailed() {
        return matchRepository.findAllByOrderByMatchNumber()
                .stream()
                .map(MatchDetailedDTO::new)
                .toList();
    }
}