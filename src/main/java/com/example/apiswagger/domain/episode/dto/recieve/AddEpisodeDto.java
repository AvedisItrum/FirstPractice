package com.example.apiswagger.domain.episode.dto.recieve;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddEpisodeDto {

    @NotNull(message = "Number can't be null")
    private int number;

    @NotBlank(message = "Synopsis can't be empty")
    private String synopsis;

    @NotBlank(message = "Link can't be empty")
    private String link;
}
