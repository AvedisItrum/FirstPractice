package com.example.apiswagger.domain.staff;

import com.example.apiswagger.domain.film.Film;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

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

    @ManyToMany(mappedBy = "directors")
    private Set<Film> directedFilms;

    @ManyToMany(mappedBy = "writers")
    private Set<Film> writtenFilms;

    @ManyToMany(mappedBy = "actors")
    private Set<Film> actoredFilms;

}
