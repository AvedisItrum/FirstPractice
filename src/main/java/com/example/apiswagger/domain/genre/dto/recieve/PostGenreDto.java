package com.example.apiswagger.domain.genre.dto.recieve;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostGenreDto {
    @NotBlank(message = "Name can't be empty")
    private String name;
}
