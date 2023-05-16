package com.example.apiswagger.domain.staff;

import com.example.apiswagger.domain.film.Film;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "Staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name can't be empty")
    private String name;

    @NotNull(message = "Avatar can't be empty")
    private byte[] image;

    @ManyToMany
    @JsonIgnore
    private Set<Film> directedFilms;

    @ManyToMany
    @JsonIgnore
    private Set<Film> writtenFilms;

    @ManyToMany
    @JsonIgnore
    private Set<Film> actoredFilms;
}
