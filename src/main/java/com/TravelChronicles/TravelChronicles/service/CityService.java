package com.TravelChronicles.TravelChronicles.service;

import com.TravelChronicles.TravelChronicles.model.CityDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {
    void saveCity();

    List<CityDTO> getCities();

    CityDTO findById();

    void deleteCity(long id);

    void addCityToCountry(long countryId, long cityId);

    void updateCity(long id, CityDTO city);
}
