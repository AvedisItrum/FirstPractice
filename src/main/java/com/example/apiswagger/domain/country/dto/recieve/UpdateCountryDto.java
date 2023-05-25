package com.example.apiswagger.domain.country.dto.recieve;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCountryDto {
    @NotBlank(message = "Name can't be null")
    private String name;
}
