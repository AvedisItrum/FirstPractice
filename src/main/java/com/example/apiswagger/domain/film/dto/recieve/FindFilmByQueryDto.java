package com.example.apiswagger.domain.film.dto.recieve;

import com.example.apiswagger.domain.film.FilmType;
import jakarta.annotation.Nullable;
import lombok.Value;

//Убрал private потому что @value делает это автоматически
@Value
@Nullable
public class FindFilmByQueryDto {
    @Nullable
    String title;
    @Nullable
    FilmType type;
    @Nullable
    Integer yearFrom;
    @Nullable
    Integer yearTo;
    @Nullable
    Double ratingFrom;
    @Nullable
    Double ratingTo;
    @Nullable
    Long[] genres;
    @Nullable
    Long[] countries;
}
