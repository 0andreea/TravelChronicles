package com.TravelChronicles.TravelChronicles.service.impl;

import com.TravelChronicles.TravelChronicles.model.CityDTO;
import com.TravelChronicles.TravelChronicles.service.CityService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityServiceImpl implements CityService {
    @Override
    public void saveCity() {

    }

    @Override
    public List<CityDTO> getCities() {
        return List.of();
    }

    @Override
    public CityDTO findById() {
        return null;
    }

    @Override
    public void deleteCity(long id) {

    }

    @Override
    public void addCityToCountry(long countryId, long cityId) {

    }

    @Override
    public void updateCity(long id, CityDTO city) {

    }
}
