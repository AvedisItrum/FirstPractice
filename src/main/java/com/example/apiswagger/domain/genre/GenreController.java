package com.example.apiswagger.domain.genre;

import com.example.apiswagger.domain.genre.dto.recieve.PostGenreDto;
import com.example.apiswagger.domain.genre.dto.recieve.PutGenreDto;
import com.example.apiswagger.domain.web.dto.IdResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @PutMapping("genres/{id}")
    private ResponseEntity updateGenre(@PathVariable("id") Long id, @RequestBody @Valid PutGenreDto genreDto) {
        return ResponseEntity.status(HttpStatus.OK).body(genreService.updateGenre(id, genreDto));
    }
    @DeleteMapping("genres/{id}")
    private ResponseEntity deleteGenre(@PathVariable("id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(new IdResponseDto(genreService.deleteGenre(id)));
    }

    @PostMapping("genre")
    private ResponseEntity createGenre(@RequestBody @Valid PostGenreDto genreDto) {
        return ResponseEntity.status(HttpStatus.OK).body(genreService.createGenre(genreDto));
    }

    @GetMapping("genres")
    private ResponseEntity getAllGenres() {
        return ResponseEntity.status(HttpStatus.OK).body(genreService.getAllGenres());
    }


}
