package com.example.apiswagger.domain.film;

import com.example.apiswagger.domain.image.Image;
import com.example.apiswagger.domain.country.Country;
import com.example.apiswagger.domain.genre.Genre;
import com.example.apiswagger.domain.staff.Staff;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "Films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @ManyToMany
    private Set<Genre> genres;

    @ManyToMany
    private Set<Country> countries;

    @OneToMany
    private Set<Image> posters;

    @ManyToMany
    @JsonIgnore
    private Set<Staff> directors;

    @ManyToMany
    @JsonIgnore
    private Set<Staff> writers;

    @ManyToMany
    @JsonIgnore
    private Set<Staff> actors;


}
