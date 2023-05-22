package com.example.apiswagger.domain.film.dto.send;

import com.example.apiswagger.domain.image.Image;
import com.example.apiswagger.domain.country.Country;
import com.example.apiswagger.domain.film.FilmType;
import com.example.apiswagger.domain.genre.Genre;
import com.example.apiswagger.domain.staff.Staff;

import java.util.Set;

public interface GetFilmDto {
     Long getId();

     String getTitle();

     String getPlot();

     FilmType getType();

     int getYear();

     String getTrailer();

     double getImdbRating();

     Set<Genre> getGenres();

     Set<Country> getCountries();

     Set<Image> getPosters();

     Set<Staff> getDirectors();

     Set<Staff> getWriters();

     Set<Staff> getActors();
}
