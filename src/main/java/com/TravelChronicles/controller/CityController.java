package com.TravelChronicles.controller;

import com.TravelChronicles.entity.City;
import com.TravelChronicles.model.CityDTO;
import com.TravelChronicles.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public void save(@RequestBody CityDTO city) {
        cityService.save(city);
    }

    @GetMapping("/{id}")
    public CityDTO findById(@PathVariable long id) {
        return cityService.findById(id);
    }

    @GetMapping
    public List<City> getCities() {
        return cityService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        cityService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody CityDTO city) {
        cityService.update(id, city);
    }

    @PostMapping("/{countryId}/{cityId}")
    public void addCityToCountry(@PathVariable long countryId, @PathVariable long cityId) {
        cityService.addCityToCountry(countryId, cityId);
    }

    public List<City> mostExpensiveCity() {
        return cityService.mostExpensiveCity();
    }

}