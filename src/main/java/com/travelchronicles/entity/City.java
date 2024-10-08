package com.travelchronicles.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String cityName;

    private String foodEaten;

    private String placesVisited;

    private int daysSpent;

    private int cost;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonIgnore
    private Country country;
}
