package com.example.apiswagger.domain.genre.dto.recieve;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddGenreDto {
    @NotBlank(message = "Name can't be empty")
    private String name;
}
