package com.example.apiswagger.domain.film;

import com.example.apiswagger.domain.film.dto.recieve.FindFilmByQueryDto;
import com.example.apiswagger.domain.film.dto.recieve.PostFilmDto;
import com.example.apiswagger.domain.film.dto.recieve.PutFilmDto;
import com.example.apiswagger.domain.season.Season;
import com.example.apiswagger.domain.season.dto.PutSeasonDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface FilmService {
    //Create

    Film createFilm(PostFilmDto film);

    //Read
    Season[] getSeasonByFilmId(Long id);

    Page<Film> getAllFilteredBy(FindFilmByQueryDto queryDto, PageRequest page);

    //Update
    Film updateFilm(Long id, PutFilmDto film);

    Season addSeasonToFilm(Long id, PutSeasonDto seasonDto);

    //Delete
    Long deleteFilmById(Long id);
}
