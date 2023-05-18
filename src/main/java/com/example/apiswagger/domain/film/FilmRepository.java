package com.example.apiswagger.domain.film;

import org.springframework.data.jpa.repository.JpaRepository;
public interface FilmRepository extends JpaRepository<Film,Long> {
}
