package com.chaos_trials.api.util.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.audience}")
    private String audience;

    public String generateToken(String username) {
        try{
            return JWT.create()
                    .withIssuer(issuer)
                    .withAudience(audience)
                    .withSubject(username)
                    .withExpiresAt(genExpirationDate())
                    .sign(Algorithm.HMAC256(secret));
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro enquanto gerava o token", exception);
        }
    }

    // Método não estático
    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plusYears(999).toInstant(ZoneOffset.of("-03:00"));
    }
}

