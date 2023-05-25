package com.example.apiswagger.domain.episode;

import com.example.apiswagger.domain.episode.dto.recieve.UpdateEpisodeDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Number can't be null")
    private Integer number;

    @NotBlank(message = "Synopsis can't be empty")
    private String synopsis;

    @NotBlank(message = "Link can't be empty")
    private String link;

    public Episode update(UpdateEpisodeDto episodeDto){
        number = episodeDto.getNumber();
        synopsis = episodeDto.getSynopsis();
        link = episodeDto.getLink();
        return this;
    }

}
