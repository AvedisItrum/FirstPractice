package com.example.apiswagger.domain.country;

import com.example.apiswagger.domain.country.dto.recieve.UpdateCountryDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name can't be null")
    private String name;

    public Country update(UpdateCountryDto countryDto){
        name = countryDto.getName();
        return this;
    }
}
