package com.example.apiswagger.domain.genre.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PutGenreDto {
    @NotBlank(message = "Name can't be empty")
    String name;
}
