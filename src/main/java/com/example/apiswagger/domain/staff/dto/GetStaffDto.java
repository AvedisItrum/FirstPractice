package com.example.apiswagger.domain.staff.dto;

import com.example.apiswagger.domain.film.Film;
import java.util.Set;

public interface GetStaffDto {
    Long getId();

    String getName();

    byte[] getImage();

    Set<Film> getDirectedFilms();

    Set<Film> getWrittenFilms();

    Set<Film> getActoredFilms();
}
