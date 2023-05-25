package com.example.apiswagger.domain.country;

import com.example.apiswagger.domain.country.dto.recieve.AddCountryDto;
import com.example.apiswagger.domain.country.dto.recieve.UpdateCountryDto;
import com.example.apiswagger.domain.web.dto.IdResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @PutMapping("countries/{id}")
    private ResponseEntity updateCountry(@PathVariable("id") Long id, @RequestBody @Valid UpdateCountryDto countryDto) {
        return ResponseEntity.status(HttpStatus.OK).body(countryService.updateCountry(id, countryDto));
    }

    @PostMapping("country")
    private ResponseEntity addCountry(@RequestBody AddCountryDto countryDto) {
        return ResponseEntity.status(HttpStatus.OK).body(countryService.addCountry(countryDto));
    }

    @GetMapping("countries")
    private ResponseEntity getAllCountries() {
        return ResponseEntity.status(HttpStatus.OK).body(countryService.getAll());
    }

    @DeleteMapping("countries/{id}")
    private ResponseEntity deleteCountry(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(new IdResponseDto(countryService.deleteCounty(id)));
    }
}
