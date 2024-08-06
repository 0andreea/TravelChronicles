package com.TravelChronicles.TravelChronicles.controller;

import com.TravelChronicles.TravelChronicles.model.CityDTO;
import com.TravelChronicles.TravelChronicles.service.CityService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
    public void saveCity(@RequestBody CityDTO cityDTO) {
        cityService.saveCity();
    }

    @GetMapping("/{id}")
    public CityDTO findById(@PathVariable long id) {
        return cityService.findById();
    }

    @GetMapping
    public List<CityDTO> getCities() {
        return cityService.getCities();
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable long id) {
        cityService.deleteCity(id);
    }

    @PutMapping("/{id}")
    public void updateCity(@PathVariable long id, @RequestBody CityDTO city) {
        cityService.updateCity(id, city);
    }

    @PostMapping("/{countryId}/{cityId}")
    public void addCityToCountry (@PathVariable long countryId, @PathVariable long cityId) {
        cityService.addCityToCountry(countryId, cityId);
    }

}