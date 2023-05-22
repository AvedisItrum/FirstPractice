package com.example.apiswagger.domain.film;

import com.example.apiswagger.domain.film.dto.recieve.FindFilmByQueryDto;
import com.example.apiswagger.domain.film.dto.recieve.PostFilmDto;
import com.example.apiswagger.domain.film.dto.recieve.PutFilmDto;
import com.example.apiswagger.domain.season.Season;
import com.example.apiswagger.domain.season.dto.PutSeasonDto;
import com.example.apiswagger.domain.web.dto.CustomException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    @GetMapping("/films")
    private ResponseEntity<Page<Film>> getFilm(@RequestParam(defaultValue = "") String[] properties,
                                               @RequestParam(defaultValue = "0") Integer page,
                                               @RequestParam(defaultValue = "10") Integer size,
                                               @RequestBody(required = false) FindFilmByQueryDto queryDto) {

        return ResponseEntity.status(HttpStatus.OK).body(filmService.getAllFilteredBy(queryDto, PageRequest.of(page, size, Sort.Direction.ASC, properties)));
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
