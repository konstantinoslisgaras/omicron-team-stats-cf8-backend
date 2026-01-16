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
import solipsismal.olympiacosfcapp.core.exceptions.CoachNotFoundException;
import solipsismal.olympiacosfcapp.dto.CoachDTO;
import solipsismal.olympiacosfcapp.dto.ErrorResponseDTO;
import solipsismal.olympiacosfcapp.model.Coach;
import solipsismal.olympiacosfcapp.repository.CoachRepository;

@RestController
@RequestMapping("/api/coach")
@RequiredArgsConstructor
public class CoachController {

    private final CoachRepository coachRepository;

    @GetMapping("/{coachId}")
    @Operation(
            summary = "Get coach by id.",
            description = "Retrieves a coach's information by their id."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Coach found",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CoachDTO.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Coach not Found",
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
    public CoachDTO getCoachById(@PathVariable String coachId) throws CoachNotFoundException {
        Coach coach = coachRepository.findById(coachId).orElseThrow(CoachNotFoundException::new);
        return new CoachDTO(coach);
    }
}