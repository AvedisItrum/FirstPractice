package com.example.apiswagger.domain.film;

import com.example.apiswagger.domain.film.dto.recieve.FindFilmByQueryDto;
import com.example.apiswagger.domain.film.dto.recieve.PostFilmDto;
import com.example.apiswagger.domain.film.dto.recieve.PutFilmDto;
import com.example.apiswagger.domain.film.specs.FilmSpecifications;
import com.example.apiswagger.domain.season.Season;
import com.example.apiswagger.domain.season.dto.PutSeasonDto;
import com.example.apiswagger.domain.web.dto.CustomException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Film createFilm(@Valid PostFilmDto film) {
        return filmRepository.save(modelMapper.map(film, Film.class));
    }

    @Override
    public Film updateFilm(Long id,@Valid PutFilmDto film) {
        if (!filmRepository.existsById(id))
            throw CustomException.IdNotFound(Film.class).get();

        Film newFilm = modelMapper.map(film, Film.class);
        newFilm.setId(id);
        return filmRepository.save(newFilm);
    }

    @Override
    public Season addSeasonToFilm(Long id,@Valid PutSeasonDto seasonDto) {
        Film film = filmRepository.findById(id).orElseThrow(CustomException.IdNotFound(Film.class));
        Season season = modelMapper.map(seasonDto, Season.class);
        film.addSeason(season);
        return season;
    }

    @Override
    public Long deleteFilmById(Long id) {
        filmRepository.findById(id).orElseThrow(CustomException.IdNotFound(Film.class));
        filmRepository.deleteById(id);
        return id;
    }

    @Override
    public Season[] getSeasonByFilmId(Long id){
        Film film = filmRepository.findById(id).orElseThrow(CustomException.IdNotFound(Film.class));

        if (film.getType() != FilmType.SERIES)
            throw new CustomException(film.getTitle() + " is not a series");

        return film.getSeasons().toArray(new Season[0]);
    }

    @Override
    public Page<Film> getAllFilteredBy( FindFilmByQueryDto queryDto, PageRequest page) {
        if(queryDto == null)
            return filmRepository.findAll(page);
        return filmRepository.findAll(FilmSpecifications.isFitsForQuery(queryDto),page);
    }
}