package com.example.apiswagger.domain.film;

import com.example.apiswagger.domain.country.Country;
import com.example.apiswagger.domain.genre.Genre;
import com.example.apiswagger.domain.image.Image;
import com.example.apiswagger.domain.season.Season;
import com.example.apiswagger.domain.staff.Staff;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "films")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title can't be empty")
    private String title;

    @NotBlank(message = "Plot can't be empty")
    private String plot;

    @NotNull(message = "Type can't be null")
    @Enumerated(EnumType.STRING)
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
    private Set<Staff> directors;

    @ManyToMany
    private Set<Staff> writers;

    @ManyToMany
    private Set<Staff> actors;

    @OneToMany
    @Nullable
    private Set<Season> seasons;

    public boolean addSeason(@Valid Season season) {
        return seasons.add(season);
    }
}
