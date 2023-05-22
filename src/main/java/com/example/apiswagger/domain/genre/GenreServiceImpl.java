package com.example.apiswagger.domain.genre;

import com.example.apiswagger.domain.genre.dto.recieve.AddGenreDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService{
    private final GenreRepository genreRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public Genre createGenre(AddGenreDto genreDto) {
       return genreRepository.save(modelMapper.map(genreDto,Genre.class));
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }
}
