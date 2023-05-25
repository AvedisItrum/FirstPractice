package com.example.apiswagger.domain.genre;

import com.example.apiswagger.domain.genre.dto.recieve.PostGenreDto;
import com.example.apiswagger.domain.genre.dto.recieve.PutGenreDto;

import java.util.List;
import java.util.Set;

public interface GenreService {
    Genre createGenre(PostGenreDto genreDto);

    Genre updateGenre(Long id, PutGenreDto genreDto);

    Long deleteGenre(Long id);

    List<Genre> getAllGenres();

    Set<Genre> getAllGenresByIds(Set<Long> ids);
}
