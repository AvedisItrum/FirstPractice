package com.example.apiswagger.domain.genre;

import com.example.apiswagger.domain.genre.dto.recieve.AddGenreDto;

import java.util.List;

public interface GenreService {
    Genre createGenre(AddGenreDto genreDto);

    List<Genre> getAllGenres();
}
