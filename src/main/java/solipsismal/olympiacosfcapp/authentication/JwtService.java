package solipsismal.olympiacosfcapp.authentication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Signature;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtService {

    @Value("${app.security.secret-key}")
    private String secretKey;

    @Value("${app.security.jwt-expiration}")
    private Long jwtExpiration;

    public String generateToken(String username, String role) {
        var claims = new HashMap<String, Object>();
        claims.put("role", role);
        return Jwts
                .builder()
                .setIssuer("self")
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(getSignInKey(), SignatureAlgorith.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String subject = extractSubject(token);
        return (subject.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    public
}
