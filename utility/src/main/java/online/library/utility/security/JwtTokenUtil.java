package online.library.utility.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class JwtTokenUtil implements Serializable {
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    private String secret = "kfbgkfgbf0";
    private SignatureAlgorithm algo = SignatureAlgorithm.HS512;

    private TokenContent getContentFromClaims(Claims claims) {
        return new TokenContent((UUID) claims.get("id"), (String) claims.get("name"), (String) claims.get("surname"), claims.getSubject(), (String) claims.get("email"), (String) claims.get("userType"));
    }

    private String getSubject(Claims claims) {
        return claims.getSubject();
    }

    private Boolean isExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }

    private Optional<Claims> getAllClaimsFromToken(String token) {
        return Optional.of(Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody());
    }

    private String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(algo, secret)
                .compact();
    }

    private Boolean validateToken(String token, TokenContent tokenContent) {
        return getAllClaimsFromToken(token)
                .map(claims -> getSubject(claims).equals(tokenContent.getUsername()) && !isExpired(claims))
                .orElseThrow(() -> new IllegalArgumentException("Claims cannot be parsed"));
    }
}
