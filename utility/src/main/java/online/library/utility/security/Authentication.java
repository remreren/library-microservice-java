package online.library.utility.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

public class Authentication {

    private static final String secret = "testing";
    private static final SignatureAlgorithm algo = SignatureAlgorithm.HS512;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    public static <Request, Response> Response authenticate(String header, BiFunction<TokenContent, String, Response> run) {
        var valid = validate(header);
        if (valid) return run.apply(new TokenContent(), header);
        else throw new IllegalStateException("Token is not valid");
    }

    private static TokenContent getContentFromClaims(Claims claims) {
        return new ObjectMapper().convertValue(claims, TokenContent.class);
    }

    private static Optional<Claims> getAllClaimsFromToken(String token) {
        return Optional.of(Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody());
    }

    private static Boolean isExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }

    private static String getSubject(Claims claims) {
        return claims.getSubject();
    }

    private static Boolean validate(String token) {
        return getAllClaimsFromToken(token)
                .map(claims -> validateToken(claims, getContentFromClaims(claims)))
                .orElseThrow(() -> new IllegalArgumentException("Claims cannot be parsed"));
    }

    private static Boolean validateToken(Claims claims, TokenContent tokenContent) {
        return getSubject(claims).equals(tokenContent.getUsername()) && !isExpired(claims);
    }

    private static String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(algo, secret)
                .compact();
    }
}
