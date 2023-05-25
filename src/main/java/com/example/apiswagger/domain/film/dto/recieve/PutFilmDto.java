package com.example.apiswagger.domain.film.dto.recieve;

import com.example.apiswagger.domain.film.FilmType;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PutFilmDto {
    @NotBlank(message = "Title can't be empty")
    private String title;

    @NotBlank(message = "Plot can't be empty")
    private String plot;

    @NotNull(message = "Type can't be null")
    private FilmType type;

    @NotNull(message = "Year can't be null")
    private int year;

    @NotBlank(message = "Trailer can't be empty")
    private String trailer;

    @NotNull(message = "Imdb rating can't be null")
    private double imdbRating;

    @Nullable
    private Set<Long> oldPosters;

    @Nullable
    private Set<MultipartFile> newPosters;

    @NotNull(message = "Countries can't be null")
    private Set<Long> countries;

    @NotNull(message = "Genres can't be null")
    private Set<Long> genres;

    @NotNull(message = "Directors can't be null")
    private Set<Long> directors;

    @NotNull(message = "Writers can't be null")
    private Set<Long> writers;

    @NotNull(message = "Actors can't be null")
    private Set<Long> actors;

}
