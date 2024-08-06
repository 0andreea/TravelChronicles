package com.TravelChronicles.TravelChronicles.controller;


import com.TravelChronicles.TravelChronicles.model.CountryDTO;
import com.TravelChronicles.TravelChronicles.service.CountryService;
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
    public void saveCountry(@RequestBody CountryDTO countryDTO) {
        countryService.saveCountry();
    }

    @GetMapping("/{id}")
    public CountryDTO findById(@PathVariable long id) {
        return countryService.findById();
    }

    @GetMapping
    public List<CountryDTO> getCountries() {
        return countryService.getCountries();
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable long id) {
        countryService.deleteCountry(id);
    }

    @PutMapping("/{id}")
    public void update (@PathVariable long id, @RequestBody CountryDTO country) {
        countryService.update(id, country);
    }
}
