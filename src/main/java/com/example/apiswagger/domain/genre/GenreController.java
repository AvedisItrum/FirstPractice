package com.example.apiswagger.domain.genre;

import com.example.apiswagger.domain.genre.dto.recieve.AddGenreDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @PostMapping("/genre")
    private Genre createGenre(@RequestBody @Valid AddGenreDto genreDto){
       return genreService.createGenre(genreDto);
    }

    @GetMapping("/genres")
    private List<Genre> getAllGenres(){
        return genreService.getAllGenres();
    }
}
