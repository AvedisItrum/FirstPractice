package com.example.apiswagger.domain.genre;

import com.example.apiswagger.domain.genre.dto.recieve.PostGenreDto;
import com.example.apiswagger.domain.genre.dto.recieve.PutGenreDto;
import com.example.apiswagger.domain.web.dto.CustomExceptions;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Genre createGenre(@Valid PostGenreDto genreDto) {
        return genreRepository.save(modelMapper.map(genreDto, Genre.class));
    }

    @Override
    public Genre updateGenre(Long id, PutGenreDto genreDto) {
        Genre genre = genreRepository
                .findById(id)
                .orElseThrow(CustomExceptions.IdNotFound(Genre.class, id));
        return genreRepository.save(genre.update(genreDto));
    }

    @Override
    public Long deleteGenre(Long id) {
        genreRepository.delete(genreRepository
                .findById(id)
                .orElseThrow(CustomExceptions.IdNotFound(Genre.class, id)));
        return id;
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Set<Genre> getAllGenresByIds(Set<Long> ids) {
        Set<Genre> genres = genreRepository.findAllByIdIn(ids);
        if (genres.size() == ids.size())
            return genres;

        Iterator<Long> iterator = genres.stream().map(Genre::getId).iterator();

        while (iterator.hasNext())
            ids.remove(iterator.next());

        throw CustomExceptions.IdsNotFound(Genre.class, ids).get();
    }
}
