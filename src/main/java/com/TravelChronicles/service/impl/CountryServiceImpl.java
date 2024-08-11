package com.TravelChronicles.service.impl;

import com.TravelChronicles.entity.City;
import com.TravelChronicles.entity.Country;
import com.TravelChronicles.model.CountryDTO;
import com.TravelChronicles.repository.CityRepository;
import com.TravelChronicles.repository.CountryRepository;
import com.TravelChronicles.service.CountryService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    public CountryServiceImpl(CountryRepository countryRepository, CityRepository cityRepository) {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public void save(CountryDTO countryDTO) {
        countryRepository.save(countryDTO.convertToEntity());
    }

    @Override
    public List<Country> findAll() {
        List<Country> country = countryRepository.findAll();
        return country;
    }

    @Override
    public void deleteById(long id) {
        Country country = countryRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Country with Id " + id + " not found"));

        for (City city : country.getCities()) {
            city.setCountry(null);
            cityRepository.save(city);
        }
        countryRepository.deleteById(id);
    }

    @Override
    public void update(long id, CountryDTO countryDTO) {
        Country oldCountry = countryRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Country with Id " + id + " not found"));
        oldCountry.setCountryName(countryDTO.countryName());
        oldCountry.setLanguageSpoken(countryDTO.languageSpoken());
        oldCountry.setCurrency(countryDTO.currency());
        oldCountry.setCapital(countryDTO.capital());
        countryRepository.save(oldCountry);
    }

    @Override
    public CountryDTO findById(long id) {
        Country country = countryRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Country with Id " + id + " not found"));
        return CountryDTO.convertToDTO(country);
    }
}
