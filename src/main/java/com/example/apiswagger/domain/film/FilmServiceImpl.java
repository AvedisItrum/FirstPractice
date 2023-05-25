package com.example.apiswagger.domain.film;

import com.example.apiswagger.domain.country.CountryService;
import com.example.apiswagger.domain.film.dto.recieve.FindFilmByQueryDto;
import com.example.apiswagger.domain.film.dto.recieve.PostFilmDto;
import com.example.apiswagger.domain.film.dto.recieve.PutFilmDto;
import com.example.apiswagger.domain.film.specs.FilmSpecifications;
import com.example.apiswagger.domain.genre.GenreService;
import com.example.apiswagger.domain.image.Image;
import com.example.apiswagger.domain.image.ImageService;
import com.example.apiswagger.domain.image.dto.recieve.AddImageDto;
import com.example.apiswagger.domain.season.Season;
import com.example.apiswagger.domain.season.SeasonRepository;
import com.example.apiswagger.domain.season.dto.recieve.PutSeasonDto;
import com.example.apiswagger.domain.staff.StaffService;
import com.example.apiswagger.domain.web.dto.CustomExceptions;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.nio.file.FileAlreadyExistsException;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final GenreService genreService;
    private final CountryService countryService;
    private final ImageService imageService;
    private final StaffService staffService;
    private final SeasonRepository seasonRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @PostConstruct
    public void PostConstruct() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public Film createFilm(@Valid PostFilmDto filmDto) {
        return filmRepository.save(convertFromDto(filmDto));
    }

    @Override
    public Film updateFilm(Long id, @Valid PutFilmDto filmDto) {
        filmRepository
                .findById(id)
                .orElseThrow(CustomExceptions.IdNotFound(Film.class, id));
        Film film = convertFromDto(filmDto);
        film.setId(id);
        return filmRepository.save(film);

    }

    @Override
    public Season addSeasonToFilm(Long id, @Valid PutSeasonDto seasonDto) {
        Film film = filmRepository
                .findById(id)
                .orElseThrow(CustomExceptions.IdNotFound(Film.class, id));
        Season season = modelMapper.map(seasonDto, Season.class);
        if (!film.addSeason(season)) {
            try {
                throw CustomExceptions.FileAlreadyExists("Episode").get();
            } catch (FileAlreadyExistsException e) {
                throw new RuntimeException(e);
            }
        }
        seasonRepository.save(season);
        filmRepository.save(film);
        return season;
    }

    @Override
    public Long deleteFilmById(Long id) {
        filmRepository.findById(id).orElseThrow(CustomExceptions.IdNotFound(Film.class, id));
        filmRepository.deleteById(id);
        return id;
    }

    @Override
    public Film convertFromDto(PutFilmDto dto) {
        Film film = modelMapper.map(dto, Film.class);

        Set<Image> posters = new HashSet<>();

        if (dto.getOldPosters() != null)
            posters.addAll(imageService.getImagesByIds(dto.getOldPosters()));

        if (dto.getNewPosters() != null)
            posters.addAll(dto
                    .getNewPosters()
                    .stream()
                    .map(x -> imageService.addImage(new AddImageDto(x)))
                    .toList());

        film.setPosters(posters);

        film.setCountries(countryService.getCountriesByIds(dto.getCountries()));
        film.setGenres(genreService.getAllGenresByIds(dto.getGenres()));
        film.setActors(staffService.getStaffByIds(dto.getActors()));
        film.setDirectors(staffService.getStaffByIds(dto.getDirectors()));
        film.setWriters(staffService.getStaffByIds(dto.getWriters()));

        return film;
    }

    @Override
    public Film convertFromDto(PostFilmDto dto) {
        //Жуткий костыль что бы не повторять один и тот же код
        PutFilmDto newDto = modelMapper.map(dto, PutFilmDto.class);
        newDto.setNewPosters(dto.getPosters());
        return convertFromDto(newDto);
    }

    @Override
    public Season[] getSeasonByFilmId(Long id) {
        Film film = filmRepository.findById(id).orElseThrow(CustomExceptions.IdNotFound(Film.class, id));

        if (film.getType() != FilmType.SERIES)
            throw new CustomExceptions(film.getTitle() + " is not a series");

        return film.getSeasons().toArray(new Season[0]);
    }

    @Override
    public Page<Film> getAllFilteredBy(@Valid FindFilmByQueryDto queryDto) {
        PageRequest page = PageRequest.of(
                queryDto.getPage(),
                queryDto.getSize(),
                Sort.Direction.ASC,
                queryDto.getProperties());
        return filmRepository.findAll(FilmSpecifications.isFitsForQuery(queryDto), page);
    }
}