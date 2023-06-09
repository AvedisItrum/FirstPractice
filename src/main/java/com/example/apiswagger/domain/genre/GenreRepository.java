package com.example.apiswagger.domain.genre;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface GenreRepository extends JpaRepository<Genre,Long> {
    Set<Genre> findAllByIdIn(Set<Long> ids);
}
