package com.example.apiswagger.domain.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtPairDto {
    private String refreshToken;
    private String accessToken;
}
