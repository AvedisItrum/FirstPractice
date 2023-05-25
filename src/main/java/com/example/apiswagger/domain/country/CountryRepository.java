package com.example.apiswagger.domain.country;

import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface CountryRepository extends CrudRepository<Country,Long> {
    @Override
    @NonNull
    List<Country> findAll();
    Set<Country> findAllByIdIn(Set<Long> ids);
}
