package com.example.apiswagger.domain.film.dto.recieve;

import com.example.apiswagger.domain.film.FilmType;
import jakarta.annotation.Nullable;
import lombok.*;

@Getter
@Setter
public class FindFilmByQueryDto {
    public FindFilmByQueryDto(String[] properties,
                              Integer page,
                              Integer size,
                              String title,
                              FilmType type,
                              Integer yearFrom,
                              Integer yearTo,
                              Double ratingFrom,
                              Double ratingTo,
                              Long[] genres,
                              Long[] countries) {
        this.page = page==null?0:page;
        this.size = size==null?10:size;
        this.properties = properties==null?new String[]{"id"}:properties;
        this.title = title;
        this.type = type;
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
        this.ratingFrom = ratingFrom;
        this.ratingTo = ratingTo;
        this.genres = genres;
        this.countries = countries;
    }

    private String[] properties;
    private Integer page;
    private Integer size;
    @Nullable
    private String title;
    @Nullable
    private FilmType type;
    @Nullable
    private Integer yearFrom;
    @Nullable
    private Integer yearTo;
    @Nullable
    private Double ratingFrom;
    @Nullable
    private Double ratingTo;
    @Nullable
    private Long[] genres;
    @Nullable
    private Long[] countries;
}
