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
import solipsismal.olympiacosfcapp.model.DetailedBio;
import solipsismal.olympiacosfcapp.repository.DetailedBioRepository;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class DetailedBioController {

    private final DetailedBioRepository detailedBioRepository;

    @GetMapping("/{playerId}/{detailedBioId}")
    @Operation(
            summary = "Get bio by id.",
            description = "Retrieves a biography by id."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Biography found",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = DetailedBioDTO.class))
    )
    @ApiResponse(responseCode = "404", description = "Player biography not Found")
    public DetailedBioDTO getDetailedBioById(@PathVariable String playerId, @PathVariable String detailedBioId) throws DetailedBioNotFoundException {
        DetailedBio detailedBio = detailedBioRepository.findById(detailedBioId).orElseThrow(DetailedBioNotFoundException::new);
        return new DetailedBioDTO(detailedBio);
    }
}