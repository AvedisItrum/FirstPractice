package com.example.apiswagger.domain.genre.dto.recieve;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PutGenreDto {
    @NotNull(message = "Name can't be null")
    private String name;
}
