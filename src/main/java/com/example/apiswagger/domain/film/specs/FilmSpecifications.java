package com.example.apiswagger.domain.film.specs;

import com.example.apiswagger.domain.film.Film;
import com.example.apiswagger.domain.film.dto.recieve.FindFilmByQueryDto;
import com.example.apiswagger.domain.genre.Genre;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FilmSpecifications {
    public static Specification<Film> isFitsForQuery(FindFilmByQueryDto queryDto) {
        if (queryDto == null)
            return null;
        List<Specification<Film>> specifications = new ArrayList<>();

        if (queryDto.getTitle() != null) {
            specifications.add((root, query, builder) -> builder.like(root.get("title"), "%" + queryDto.getTitle() + "%"));
        }
        if (queryDto.getType() != null) {
            specifications.add((root, query, builder) -> builder.equal(root.get("type"), queryDto.getType()));
        }
        if (queryDto.getYearFrom() != null) {
            specifications.add((root, query, builder) -> builder.greaterThanOrEqualTo(root.get("year"), queryDto.getYearFrom()));
        }
        if (queryDto.getYearTo() != null) {
            specifications.add((root, query, builder) -> builder.lessThanOrEqualTo(root.get("year"), queryDto.getYearTo()));
        }
        if (queryDto.getRatingFrom() != null) {
            specifications.add((root, query, builder) -> builder.greaterThanOrEqualTo(root.get("imdbRating"), queryDto.getRatingFrom()));
        }
        if (queryDto.getRatingTo() != null) {
            specifications.add((root, query, builder) -> builder.lessThanOrEqualTo(root.get("imdbRating"), queryDto.getRatingTo()));
        }
        if (queryDto.getGenres() != null) {
            for (var genre :queryDto.getGenres()) {
                specifications.add((root, query, builder) -> builder.isMember(genre, root.<Set<Genre>>get("genres").get("id")));
            }
        }
        if (queryDto.getCountries() != null) {
            for (var country :queryDto.getCountries()) {
                specifications.add((root, query, builder) -> builder.isMember(country, root.<Set<Genre>>get("countries").get("id")));
            }        }
        return Specification.allOf(specifications);
    }

}
