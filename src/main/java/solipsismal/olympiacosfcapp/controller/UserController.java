package solipsismal.olympiacosfcapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import solipsismal.olympiacosfcapp.core.exceptions.PlayerNotFoundException;
import solipsismal.olympiacosfcapp.core.exceptions.UserNotFoundException;
import solipsismal.olympiacosfcapp.dto.UserDTO;
import solipsismal.olympiacosfcapp.dto.UserUpdateDTO;
import solipsismal.olympiacosfcapp.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    @Operation(
            summary = "Get user profile",
            description = "Retrieves the authenticated user's profile information"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Profile data retrieved successfully",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = UserDTO.class))
    )
    @ApiResponse(
            responseCode = "401",
            description = "Unauthorized - Login required",
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
    public ResponseEntity<UserDTO> getProfile() throws UserNotFoundException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return ResponseEntity.ok(userService.getUserProfile(username));
    }

    @PutMapping("/profile")
    @Operation(
            summary = "Update user profile",
            description = "Updates the authenticated user's profile information"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Profile updated successfully",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = UserDTO.class))
    )
    @ApiResponse(
            responseCode = "400",
            description = "Invalid update data",
            content = @Content
    )
    @ApiResponse(
            responseCode = "401",
            description = "Unauthorized - Login required",
            content = @Content
    )
    @ApiResponse(
            responseCode = "404",
            description = "User or player not found",
            content = @Content
    )
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content
    )
    public ResponseEntity<UserDTO> updateProfile(@Valid @RequestBody UserUpdateDTO dto) throws UserNotFoundException, PlayerNotFoundException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return ResponseEntity.ok(userService.updateUserProfile(username, dto));
    }

    @GetMapping("/user/{username}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @Operation(
            summary = "Get any user by username (Super Admin)",
            description = "Retrieves any user's profile by username - Super Admin only"
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
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUserProfile(username));
    }
}