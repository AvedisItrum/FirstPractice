package com.example.apiswagger.domain.episode;

import com.example.apiswagger.domain.episode.dto.recieve.UpdateEpisodeDto;
import com.example.apiswagger.domain.episode.dto.recieve.AddEpisodeDto;

public interface EpisodeService {
    Episode updateEpisode(Long id,UpdateEpisodeDto episodeDto);

    Long deleteEpisode(Long id);

    Episode addEpisode(AddEpisodeDto episodeDto);
}
