package com.example.apiswagger.domain.episode;

import com.example.apiswagger.domain.episode.dto.recieve.UpdateEpisodeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EpisodeController {
    private final EpisodeService episodeService;

    @PutMapping("episodes/{id}")
    private ResponseEntity updateEpisode(@PathVariable("id") Long id, @ModelAttribute UpdateEpisodeDto episodeDto) {
        return ResponseEntity.status(HttpStatus.OK).body(episodeService.updateEpisode(id, episodeDto));
    }

    @DeleteMapping("episodes/{id}")
    private ResponseEntity deleteEpisode(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(episodeService.deleteEpisode(id));
    }
}
