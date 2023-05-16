package com.example.apiswagger.domain.season.dto;

import com.example.apiswagger.domain.episode.Episode;

import java.util.Set;

public interface GetSeasonDto {
    Long getId();

    int getNumber();

    String getSynopsis();

    Set<Episode> getEpisodes();
}
