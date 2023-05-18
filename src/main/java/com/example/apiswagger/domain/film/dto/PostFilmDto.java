package com.example.apiswagger.domain.film.dto;

import com.example.apiswagger.domain.country.Country;
import com.example.apiswagger.domain.film.FilmType;
import com.example.apiswagger.domain.genre.Genre;
import com.example.apiswagger.domain.image.Image;
import com.example.apiswagger.domain.staff.Staff;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class PostFilmDto {

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

    @NotNull(message = "Posters can't be null")
    private Set<Image> posters;

    @NotNull(message = "Countries can't be null")
    private Set<Country> countries;

    @NotNull(message = "Genres can't be null")

    private Set<Genre> genres;

    @NotNull(message = "Directors can't be null")

    private Set<Staff> directors;

    @NotNull(message = "Writers can't be null")

    private Set<Staff> writers;

    @NotNull(message = "Actors can't be null")

    private Set<Staff> actors;


}
