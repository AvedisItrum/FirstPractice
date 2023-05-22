package com.example.apiswagger.domain.genre;

import com.example.apiswagger.domain.genre.dto.recieve.PostGenreDto;

import java.util.List;

public interface GenreService {
    Genre createGenre(PostGenreDto genreDto);

    List<Genre> getAllGenres();
}
