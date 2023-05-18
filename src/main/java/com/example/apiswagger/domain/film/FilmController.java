package com.example.apiswagger.domain.film;

import com.example.apiswagger.domain.film.dto.PostFilmDto;
import com.example.apiswagger.domain.film.dto.PutFilmDto;
import com.example.apiswagger.domain.season.Season;
import com.example.apiswagger.domain.season.dto.PutSeasonDto;
import com.example.apiswagger.domain.web.dto.CustomException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class FilmController {
    private final FilmService filmService;


    //Create
    @PostMapping("/film")
    private ResponseEntity<Film> addFilm(@ModelAttribute @Valid PostFilmDto film) {
        return new ResponseEntity<>(filmService.createFilm(film), HttpStatus.OK);
    }

    //Read
    @GetMapping("/film")
    private ResponseEntity<PageImpl<Film>> getFilm(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size,
                                                   @RequestParam(required = false) String[] properties,
                                                   @RequestParam(required = false) String title,
                                                   @RequestParam(required = false) FilmType type,
                                                   @RequestParam(required = false) Integer yearFrom,
                                                   @RequestParam(required = false) Integer yearTo,
                                                   @RequestParam(required = false) Double ratingFrom,
                                                   @RequestParam(required = false) Double ratingTo,
                                                   @RequestParam(required = false) Long[] genres,
                                                   @RequestParam(required = false) Long[] countries) {

        return new ResponseEntity<>(
                new PageImpl<>(
                        filmService.getAllFilteredBy(title, type, yearFrom, yearTo, ratingFrom, ratingTo, genres, countries),
                        PageRequest.of(page, size),
                        size),
                HttpStatus.OK
        );
    }

    @GetMapping("/films/{id}/seasons")
    private ResponseEntity<Season[]> getSeasonsByFilmId(@PathVariable("id") Long id) throws CustomException {
        return new ResponseEntity<>(filmService.getSeasonByFilmId(id), HttpStatus.OK);
    }

    //Update
    @PutMapping("/films/{id}")
    private ResponseEntity<Film> updateFilm(@PathVariable("id") Long id, @RequestBody @Valid PutFilmDto newFilm) {
        return new ResponseEntity<>(filmService.updateFilm(id, newFilm), HttpStatus.OK);
    }

    @PostMapping("/film/{id}/season")
    private ResponseEntity<Season> addSeasonByFilmId(@PathVariable("id") Long id, @RequestBody @Valid PutSeasonDto season) {
        return new ResponseEntity<>(filmService.addSeasonToFilm(id, season), HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("films/{id}")
    private ResponseEntity<Long> deleteFilm(@PathVariable("id") Long id) {
        return new ResponseEntity<>(filmService.deleteFilmById(id), HttpStatus.OK);
    }
}
