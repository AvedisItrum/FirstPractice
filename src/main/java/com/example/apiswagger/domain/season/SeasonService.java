package com.example.apiswagger.domain.season;

import com.example.apiswagger.domain.episode.Episode;
import com.example.apiswagger.domain.episode.dto.recieve.AddEpisodeDto;
import com.example.apiswagger.domain.season.dto.recieve.PutSeasonDto;

public interface SeasonService {

    Season updateSeason(Long id,PutSeasonDto season);

    Long deleteSeason(Long id);

    Episode addEpisode(Long id,AddEpisodeDto episodeDto);

    Season getSeason(Long id);
}
