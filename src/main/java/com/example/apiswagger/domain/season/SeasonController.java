package com.example.apiswagger.domain.season;

import com.example.apiswagger.domain.episode.dto.recieve.AddEpisodeDto;
import com.example.apiswagger.domain.season.dto.recieve.PutSeasonDto;
import com.example.apiswagger.domain.web.dto.IdResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SeasonController {
    private final SeasonService seasonService;

    @PutMapping("seasons/{id}")
    private ResponseEntity updateSeason(@PathVariable("id")Long id,@RequestBody PutSeasonDto season){
        return ResponseEntity.status(HttpStatus.OK).body(seasonService.updateSeason(id,season));
    }

    @DeleteMapping("seasons/{id}")
    private ResponseEntity deleteSeason(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(new IdResponseDto(seasonService.deleteSeason(id)));
    }

    @PostMapping("seasons/{id}/episode")
    private ResponseEntity addEpisode(@PathVariable("id") Long id,@RequestBody AddEpisodeDto episodeDto){
        return ResponseEntity.status(HttpStatus.OK).body(seasonService.addEpisode(id,episodeDto));
    }

    @GetMapping("seasons")
    private ResponseEntity getAllSeasons(@RequestParam("seasonId")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(seasonService.getSeason(id));
    }
}
