package com.example.apiswagger.domain.film;

import com.example.apiswagger.domain.film.dto.PostFilmDto;
import com.example.apiswagger.domain.film.dto.PutFilmDto;
import com.example.apiswagger.domain.season.Season;
import com.example.apiswagger.domain.season.dto.PutSeasonDto;

import java.util.List;

public interface FilmService {
    //Create

    Film createFilm(PostFilmDto film);

    //Read
    Season[] getSeasonByFilmId(Long id);

    List<Film> getAllFilteredBy(String title,
                                FilmType type,
                                Integer yearFrom,
                                Integer yearTo,
                                Double ratingFrom,
                                Double ratingTo,
                                Long[] genres,
                                Long[] countries);

    //Update
    Film updateFilm(Long id, PutFilmDto film);

    Season addSeasonToFilm(Long id, PutSeasonDto seasonDto);

    //Delete
    Long deleteFilmById(Long id);
}
