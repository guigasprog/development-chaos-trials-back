package com.chaos_trials.api.util.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
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
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret); // Usar HMAC256 como algoritmo
            return JWT.create()
                    .withIssuer(issuer)
                    .withAudience(audience)
                    .withSubject(username)
                    .withExpiresAt(genExpirationDate()) // Gera a data de expiração
                    .sign(algorithm);
        } catch (Exception e) {
            throw new RuntimeException("Erro enquanto gerava o token", e);
        }
    }

    public String getUsernameFromToken(HttpServletRequest request) {
        String token = resolveToken(request); // Recupera o token
        DecodedJWT decodedJWT = JWT.decode(token); // Decodifica o token
        return decodedJWT.getSubject(); // Retorna o username (subject)
    }



    public String resolveToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }

    public boolean validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(issuer) // Valida o issuer
                    .withAudience(audience) // Valida o audience
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token); // Verifica o token
            return true;
        } catch (JWTVerificationException exception) {
            return false; // Caso o token seja inválido
        }
    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plusYears(999).toInstant(ZoneOffset.of("-03:00"));
    }
}

