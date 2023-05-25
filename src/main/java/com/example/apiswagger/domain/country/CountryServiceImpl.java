package com.example.apiswagger.domain.country;

import com.example.apiswagger.domain.country.dto.recieve.AddCountryDto;
import com.example.apiswagger.domain.country.dto.recieve.UpdateCountryDto;
import com.example.apiswagger.domain.web.dto.CustomExceptions;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Country updateCountry(Long id, @Valid UpdateCountryDto countryDto) {
        return countryRepository.save(
                countryRepository
                        .findById(id)
                        .orElseThrow(CustomExceptions.IdNotFound(Country.class, id))
                        .update(countryDto)
        );
    }

    @Override
    public Country addCountry(@Valid AddCountryDto countryDto) {
        return countryRepository.save(modelMapper.map(countryDto, Country.class));
    }

    @Override
    public Country[] getAll() {
        return countryRepository.findAll().toArray(new Country[0]);
    }

    @Override
    public Long deleteCounty(Long id) {
        countryRepository.delete(
                countryRepository
                        .findById(id)
                        .orElseThrow(CustomExceptions.IdNotFound(Country.class, id))
        );
        return id;
    }

    @Override
    public Set<Country> getCountriesByIds(Set<Long> countriesId) {
        Set<Country> countries = countryRepository.findAllByIdIn(countriesId);
        if (countries.size() == countriesId.size())
            return countries;

        Iterator<Long> iterator = countries.stream().map(Country::getId).iterator();

        while (iterator.hasNext())
            countriesId.remove(iterator.next());

        throw CustomExceptions.IdsNotFound(Country.class,countriesId).get();
    }
}
