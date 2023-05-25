package com.example.apiswagger.domain.staff;

import com.example.apiswagger.domain.film.Film;
import com.example.apiswagger.domain.film.dto.send.FilmWithoutStaffDto;
import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "staff")

public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name can't be empty")
    private String name;

    @NotNull(message = "Avatar can't be empty")
    private byte[] avatar;

    @JsonGetter("directedFilms")
    public Set<FilmWithoutStaffDto> getDirectedFilmsJson() {
        return directedFilms.stream().map(FilmWithoutStaffDto::new).collect(Collectors.toSet());
    }

    @JsonGetter("writtenFilms")
    public Set<FilmWithoutStaffDto> getWrittenFilmsJson() {
        return writtenFilms.stream().map(FilmWithoutStaffDto::new).collect(Collectors.toSet());
    }
    @JsonGetter("actoredFilms")
    public Set<FilmWithoutStaffDto> getActoredFilmsJson() {
        return actoredFilms.stream().map(FilmWithoutStaffDto::new).collect(Collectors.toSet());
    }

    @ManyToMany(mappedBy = "directors")
    private Set<Film> directedFilms;

    @ManyToMany(mappedBy = "writers")
    private Set<Film> writtenFilms;

    @ManyToMany(mappedBy = "actors")
    private Set<Film> actoredFilms;

}
