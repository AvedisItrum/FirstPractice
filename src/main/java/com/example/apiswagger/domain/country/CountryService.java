package com.example.apiswagger.domain.country;

import com.example.apiswagger.domain.country.dto.recieve.AddCountryDto;
import com.example.apiswagger.domain.country.dto.recieve.UpdateCountryDto;

import java.util.Set;

public interface CountryService {
    Country updateCountry(Long id, UpdateCountryDto countryDto);

    Country addCountry(AddCountryDto countryDto);

    Country[] getAll();

    Long deleteCounty(Long id);

    Set<Country> getCountriesByIds(Set<Long> countries);
}
