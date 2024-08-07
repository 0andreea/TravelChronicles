package com.TravelChronicles.controller;


import com.TravelChronicles.entity.Country;
import com.TravelChronicles.model.CountryDTO;
import com.TravelChronicles.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    public void save(@RequestBody CountryDTO country) {
        countryService.save(country);
    }

    @GetMapping("/{id}")
    public CountryDTO findById(@PathVariable long id) {
        return countryService.findById(id);
    }

    @GetMapping
    public List<Country> getCountries() {
        return countryService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        countryService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update (@PathVariable long id, @RequestBody CountryDTO country) {
        countryService.update(id, country);
    }
}
