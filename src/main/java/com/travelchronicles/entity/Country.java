package com.travelchronicles.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String countryName;

    private String languageSpoken;

    private String currency;

    private String capital;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<City> cities;

    public void add(City city) {
        this.cities.add(city);
        city.setCountry(this);
    }
}
