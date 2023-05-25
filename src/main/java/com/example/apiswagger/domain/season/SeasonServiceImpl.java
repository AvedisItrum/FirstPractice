package com.example.apiswagger.domain.season;

import com.example.apiswagger.domain.episode.Episode;
import com.example.apiswagger.domain.episode.EpisodeRepository;
import com.example.apiswagger.domain.episode.EpisodeService;
import com.example.apiswagger.domain.episode.dto.recieve.AddEpisodeDto;
import com.example.apiswagger.domain.season.dto.recieve.PutSeasonDto;
import com.example.apiswagger.domain.web.dto.CustomExceptions;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeasonServiceImpl implements SeasonService {
    private final SeasonRepository seasonRepository;
    private final EpisodeService episodeService;
    private final EpisodeRepository episodeRepository;

    @Override
    public Season updateSeason(Long id, @Valid PutSeasonDto seasonDto) {
        Season season = seasonRepository
                .findById(id)
                .orElseThrow(CustomExceptions.IdNotFound(Season.class, id));
        return season.update(seasonDto);
    }

    @Override
    public Long deleteSeason(Long id) {
        seasonRepository
                .findById(id)
                .orElseThrow(CustomExceptions.IdNotFound(Season.class, id));
        seasonRepository.deleteById(id);
        return id;
    }

    @Override
    public Episode addEpisode(Long id, @Valid AddEpisodeDto episodeDto) {
        return episodeRepository.save(
                seasonRepository
                        .findById(id)
                        .orElseThrow(CustomExceptions.IdNotFound(Season.class, id))
                        .addEpisode(episodeService.addEpisode(episodeDto)));

    }

    @Override
    public Season getSeason(Long id) {
        return seasonRepository.save(
                seasonRepository
                        .findById(id)
                        .orElseThrow(CustomExceptions.IdNotFound(Season.class, id)));
    }


}
