package com.example.apiswagger.domain.auth.dto.send;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtPairDto {
    private String refreshToken;
    private String accessToken;
}
