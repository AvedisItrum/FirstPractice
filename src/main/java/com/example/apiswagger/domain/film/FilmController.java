package com.example.apiswagger.domain.film;

import com.example.apiswagger.domain.film.dto.recieve.FindFilmByQueryDto;
import com.example.apiswagger.domain.film.dto.recieve.PostFilmDto;
import com.example.apiswagger.domain.film.dto.recieve.PutFilmDto;
import com.example.apiswagger.domain.season.dto.recieve.PutSeasonDto;
import com.example.apiswagger.domain.web.dto.IdResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class FilmController {
    private final FilmService filmService;

    // TODO: 22.05.2023 сравнить sql запросы

    @PutMapping("films/{id}")
    private ResponseEntity updateFilm(@PathVariable("id") Long id, @ModelAttribute @Valid PutFilmDto newFilm) {
        return ResponseEntity.status(HttpStatus.OK).body(filmService.updateFilm(id, newFilm));
    }

    @PostMapping("film")
    private ResponseEntity addFilm(@ModelAttribute @Valid PostFilmDto film) {
        return ResponseEntity.status(HttpStatus.OK).body(filmService.createFilm(film));
    }

    @GetMapping("films")
    private ResponseEntity getFilm(@ModelAttribute @Valid FindFilmByQueryDto queryDto) {
        return ResponseEntity.status(HttpStatus.OK).body(filmService.getAllFilteredBy(queryDto));

    }

    @GetMapping("films/{id}/seasons")
    private ResponseEntity getSeasonsByFilmId(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(filmService.getSeasonByFilmId(id));
    }

    @PostMapping("film/{id}/season")
    private ResponseEntity addSeasonByFilmId(@PathVariable("id") Long id, @ModelAttribute @Valid PutSeasonDto season) {
        return ResponseEntity.status(HttpStatus.OK).body(filmService.addSeasonToFilm(id, season));
    }

    @DeleteMapping("films/{id}")
    private ResponseEntity deleteFilm(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(new IdResponseDto(filmService.deleteFilmById(id)));
    }
}
