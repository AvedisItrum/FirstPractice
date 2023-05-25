package com.example.apiswagger.domain.season;

import com.example.apiswagger.domain.episode.Episode;
import com.example.apiswagger.domain.season.dto.recieve.PutSeasonDto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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
@Table(name = "seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private int number;

    @NotBlank
    private String synopsis;

    @OneToMany
    private Set<Episode> episodes;

    public Season update(@Valid PutSeasonDto dto){
        this.number = dto.getNumber();
        this.synopsis = dto.getSynopsis();
        return this;
    }

    public Episode addEpisode(Episode episode){
       episodes.add(episode);
       return episode;
    }
}
