package com.one.challenge.foroHub.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.one.challenge.foroHub.domain.User;
import com.one.challenge.foroHub.service.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Value("${jwt.secret.word}")
    private String secret;

    @Override
    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("foro_hub")
                    .withSubject(user.getUsername())
                    .withClaim("id", user.getId())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException();
        }
    }

    @Override
    public String getSubject(String token) {
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("foro_hub")
                    .build();

            decodedJWT = verifier.verify(token);
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Invalid");
        }
        if (decodedJWT.getSubject() == null) {
            throw new RuntimeException("Invalid verifier");
        }
        return decodedJWT.getSubject();
    }
}
