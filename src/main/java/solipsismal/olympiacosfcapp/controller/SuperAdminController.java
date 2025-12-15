package solipsismal.olympiacosfcapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import solipsismal.olympiacosfcapp.core.exceptions.CompetitionNotFoundException;
import solipsismal.olympiacosfcapp.core.exceptions.UserNotFoundException;
import solipsismal.olympiacosfcapp.dto.CompetitionDTO;
import solipsismal.olympiacosfcapp.dto.CompetitionPositionUpdateDTO;
import solipsismal.olympiacosfcapp.dto.UserDTO;
import solipsismal.olympiacosfcapp.filters.Paginated;
import solipsismal.olympiacosfcapp.model.User;
import solipsismal.olympiacosfcapp.repository.UserRepository;
import solipsismal.olympiacosfcapp.service.CompetitionService;
import solipsismal.olympiacosfcapp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/super-admin")
@RequiredArgsConstructor
public class SuperAdminController {

    private final CompetitionService competitionService;
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/competitions")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @Operation(
            summary = "Get all competitions (Super Admin)",
            description = "Retrieves all competitions - Super Admin only"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Competitions retrieved successfully",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CompetitionDTO.class))
    )
    @ApiResponse(
            responseCode = "403",
            description = "Forbidden - Admin access required",
            content = @Content
    )
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content
    )
    public ResponseEntity<List<CompetitionDTO>> getAllCompetitions() {
        List<CompetitionDTO> competitions = competitionService.findActive();
        return ResponseEntity.ok(competitions);
    }

    @PutMapping("/competitions/position")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @Operation(
            summary = "Update competition position (Super Admin)",
            description = "Updates a competition's position - Super Admin only"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Competition position updated successfully",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CompetitionDTO.class))
    )
    @ApiResponse(
            responseCode = "400",
            description = "Invalid update data",
            content = @Content
    )
    @ApiResponse(
            responseCode = "403",
            description = "Forbidden - Admin access required",
            content = @Content
    )
    @ApiResponse(
            responseCode = "404",
            description = "Competition not found",
            content = @Content
    )
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content
    )
    public ResponseEntity<CompetitionDTO> updateCompetitionPosition(@Valid @RequestBody CompetitionPositionUpdateDTO updateDTO)
            throws CompetitionNotFoundException {
        CompetitionDTO updatedCompetition = competitionService.updateCompetitionPosition(updateDTO);
        return ResponseEntity.ok(updatedCompetition);
    }

    @GetMapping("/users/{username}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @Operation(
            summary = "Get user by username (Super Admin)",
            description = "Retrieves user profile by username - Super Admin only"
    )
    @ApiResponse(
            responseCode = "200",
            description = "User found successfully",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = UserDTO.class))
    )
    @ApiResponse(
            responseCode = "403",
            description = "Forbidden - Admin access required",
            content = @Content
    )
    @ApiResponse(
            responseCode = "404",
            description = "User not found",
            content = @Content
    )
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content
    )
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        try {
            UserDTO user = userService.getUserProfile(username);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/users/count")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @Operation(
            summary = "Get total user count (Super Admin)",
            description = "Retrieves total number of users - Super Admin only"
    )
    @ApiResponse(
            responseCode = "200",
            description = "User count retrieved successfully",
            content = @Content
    )
    @ApiResponse(
            responseCode = "403",
            description = "Forbidden - Admin access required",
            content = @Content
    )
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content
    )
    public Integer getTotalUsers() {
        return Math.toIntExact(userRepository.count());
    }

    @GetMapping("/users/paginated")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @Operation(
            summary = "Get paginated users (Super Admin)",
            description = "Retrieves paginated list of users - Super Admin only"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Paginated users retrieved successfully",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Paginated.class))
    )
    @ApiResponse(
            responseCode = "400",
            description = "Invalid pagination parameters",
            content = @Content
    )
    @ApiResponse(
            responseCode = "403",
            description = "Forbidden - Admin access required",
            content = @Content
    )
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content
    )
    public ResponseEntity<Paginated<UserDTO>> getPaginatedUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Paginated<UserDTO> paginatedUsers = userService.getPaginatedUsers(page, size);
        return ResponseEntity.ok(paginatedUsers);
    }
}