package com.example.apiswagger.domain.season.dto.recieve;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PutSeasonDto {
    @NotNull(message = "Number can't be null")
    private int number;

    @NotBlank(message = "Synopsis can't be empty")
    private String synopsis;
}
