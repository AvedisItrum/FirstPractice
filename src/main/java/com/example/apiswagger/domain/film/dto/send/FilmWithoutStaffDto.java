package com.example.apiswagger.domain.film.dto.send;

import com.example.apiswagger.domain.country.Country;
import com.example.apiswagger.domain.film.Film;
import com.example.apiswagger.domain.film.FilmType;
import com.example.apiswagger.domain.genre.Genre;
import com.example.apiswagger.domain.image.Image;
import com.example.apiswagger.domain.season.Season;
import com.example.apiswagger.domain.staff.Staff;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class FilmWithoutStaffDto {
    public FilmWithoutStaffDto(Film film) {
        id = film.getId();
        title = film.getTitle();
        plot = film.getPlot();
        type = film.getType();
        year = film.getYear();
        trailer = film.getTrailer();
        imdbRating = film.getImdbRating();
        genres = film.getGenres();
        countries = film.getCountries();
        posters = film.getPosters();
        seasons = film.getSeasons();
        directors = film.getDirectors().stream().map(Staff::getId).collect(Collectors.toSet());
        writers = film.getWriters().stream().map(Staff::getId).collect(Collectors.toSet());
        actors = film.getActors().stream().map(Staff::getId).collect(Collectors.toSet());
    }

    private Long id;

    private String title;

    private String plot;

    private FilmType type;

    private int year;

    private String trailer;

    private double imdbRating;

    private Set<Genre> genres;

    private Set<Country> countries;

    private Set<Image> posters;

    private Set<Long> directors;

    private Set<Long> writers;

    private Set<Long> actors;

    private Set<Season> seasons;
}
