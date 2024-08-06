package com.TravelChronicles.TravelChronicles.service.impl;

import com.TravelChronicles.TravelChronicles.model.CountryDTO;
import com.TravelChronicles.TravelChronicles.service.CountryService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryServiceImpl implements CountryService {
    @Override
    public void saveCountry() {

    }

    @Override
    public List<CountryDTO> getCountries() {
        return List.of();
    }

    @Override
    public void deleteCountry(long id) {

    }

    @Override
    public void addCityToCountry(long countryId, long cityId) {

    }

    @Override
    public void update(long id, CountryDTO country) {

    }

    @Override
    public CountryDTO findById() {
        return null;
    }
}
