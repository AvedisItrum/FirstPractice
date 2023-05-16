package com.example.apiswagger.domain.country.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PutCountryDto {
    @NotBlank(message = "Name can't be null")
    private String name;
}
