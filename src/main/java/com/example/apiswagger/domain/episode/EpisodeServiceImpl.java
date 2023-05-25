package com.example.apiswagger.domain.episode;

import com.example.apiswagger.domain.episode.dto.recieve.AddEpisodeDto;
import com.example.apiswagger.domain.episode.dto.recieve.UpdateEpisodeDto;
import com.example.apiswagger.domain.web.dto.CustomExceptions;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EpisodeServiceImpl implements EpisodeService {
    private final EpisodeRepository episodeRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Episode updateEpisode(Long id,UpdateEpisodeDto episodeDto) {
        return episodeRepository.save(episodeRepository
                .findById(id)
                .orElseThrow(CustomExceptions.IdNotFound(Episode.class, id))
                .update(episodeDto));
    }

    @Override
    public Long deleteEpisode(Long id) {
        episodeRepository.delete(
                episodeRepository
                        .findById(id)
                        .orElseThrow(CustomExceptions.IdNotFound(Episode.class, id)));
        return id;
    }

    @Override
    public Episode addEpisode(AddEpisodeDto episodeDto) {
        return episodeRepository.save(modelMapper.map(episodeDto, Episode.class));
    }
}
