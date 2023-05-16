package com.example.apiswagger.domain.episode.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PutEpisodeDto {
    @NotNull(message = "Number can't be null")
    private int number;

    @NotBlank(message = "Synopsis can't be empty")
    private String synopsis;

    @NotBlank(message = "Link can't be empty")
    private String link;
}
