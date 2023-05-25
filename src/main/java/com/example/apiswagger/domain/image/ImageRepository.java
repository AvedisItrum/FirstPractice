package com.example.apiswagger.domain.image;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ImageRepository extends CrudRepository<Image,Long> {
    Set<Image> findAllByIdIn(Set<Long> ids);
}
