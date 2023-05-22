package com.example.apiswagger.domain.film;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FilmRepository extends JpaRepository<Film,Long>, JpaSpecificationExecutor<Film>{
}
