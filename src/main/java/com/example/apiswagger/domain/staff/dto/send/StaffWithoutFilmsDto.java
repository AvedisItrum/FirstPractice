package com.example.apiswagger.domain.staff.dto.send;

import com.example.apiswagger.domain.film.Film;
import com.example.apiswagger.domain.staff.Staff;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter

public class StaffWithoutFilmsDto {
    public StaffWithoutFilmsDto(Staff staff){
        id = staff.getId();
        name = staff.getName();
        avatar = staff.getAvatar();
        actoredFilms =staff.getActoredFilms().stream().map(Film::getId).collect(Collectors.toSet());
        writtenFilms =staff.getWrittenFilms().stream().map(Film::getId).collect(Collectors.toSet());
        directedFilms =staff.getDirectedFilms().stream().map(Film::getId).collect(Collectors.toSet());
    }
    private Long id;

    private String name;

    private byte[] avatar;

    private Set<Long> directedFilms;

    private Set<Long> writtenFilms;

    private Set<Long> actoredFilms;

}
