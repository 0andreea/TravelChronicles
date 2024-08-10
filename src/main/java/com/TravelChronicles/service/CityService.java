package com.TravelChronicles.service;

import com.TravelChronicles.entity.City;
import com.TravelChronicles.model.CityDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    void save(CityDTO cityDTO);

    CityDTO findById(long id);

    void deleteById(long id);

    void update(long id, CityDTO cityDTO);

    List<City> findAll();

    void addCityToCountry(long countryId, long cityId);

    List<City> mostExpensiveCity();
}