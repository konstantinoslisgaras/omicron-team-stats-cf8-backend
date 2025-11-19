package solipsismal.olympiacosfcapp.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import solipsismal.olympiacosfcapp.dto.AuthenticationRequestDTO;
import solipsismal.olympiacosfcapp.dto.AuthenticationResponseDTO;
import solipsismal.olympiacosfcapp.model.User;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.username(), dto.password()));

        User user = (User) authentication.getPrincipal();
        String token = jwtService.generateToken(authentication.getName(), user.getRole().name());
        return new AuthenticationResponseDTO(user.getFirstname(), user.getLastname(), token);
    }
}
