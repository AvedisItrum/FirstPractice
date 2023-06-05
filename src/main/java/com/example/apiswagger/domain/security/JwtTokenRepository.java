package com.example.apiswagger.domain.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.apiswagger.domain.auth.dto.send.JwtPairDto;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

@Repository
public class JwtTokenRepository {
    @Value("${JWT_SECRET}")
    @Getter
    private String secret;

    @PostConstruct
    private void postConstruct() {
        algorithm = Algorithm.HMAC256(secret);
        verifier = JWT.require(algorithm).build();
    }

    private Algorithm algorithm;
    private JWTVerifier verifier;

    public JwtPairDto generateJwtPair(Long customerId, long refreshTokenLifeTimeMinutes, long accessTokenLifeTimeMinutes) {
        return new JwtPairDto(generateToken(customerId, refreshTokenLifeTimeMinutes), generateToken(customerId, accessTokenLifeTimeMinutes));
    }
    public Long getCustomerID(String refreshToken){
        DecodedJWT decodedJWT = verifier.verify(refreshToken);
        return decodedJWT.getClaim("customerId").asLong();
    }

    public String generateToken(Long customerId, long lifeTimeMinutes) {
        return JWT.create()
                .withClaim("customerId", customerId)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + lifeTimeMinutes * 60 * 1000))
                .withJWTId(UUID.randomUUID()
                        .toString())
                .sign(algorithm);
    }

}
