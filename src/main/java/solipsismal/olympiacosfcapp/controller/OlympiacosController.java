package solipsismal.olympiacosfcapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solipsismal.olympiacosfcapp.core.exceptions.OlympiacosInfoNotFoundException;
import solipsismal.olympiacosfcapp.dto.ErrorResponseDTO;
import solipsismal.olympiacosfcapp.dto.OlympiacosDTO;
import solipsismal.olympiacosfcapp.repository.OlympiacosRepository;

@RestController
@RequestMapping("/api/history")
@RequiredArgsConstructor
public class OlympiacosController {

    private final OlympiacosRepository olympiacosRepository;

    @GetMapping
    @Operation(
            summary = "Get club history",
            description = "Retrieves Olympiacos FC club history and information"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Club history and information retrieved successfully",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = OlympiacosDTO.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Club information not found",
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
    public OlympiacosDTO getOlympiacosInfo() throws OlympiacosInfoNotFoundException {
        return olympiacosRepository.findAll()
                .stream()
                .findFirst()
                .map(OlympiacosDTO::new)
                .orElseThrow(OlympiacosInfoNotFoundException::new);
    }
}