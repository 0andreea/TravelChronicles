package com.travelchronicles.service.impl;

import com.travelchronicles.entity.City;
import com.travelchronicles.entity.Country;
import com.travelchronicles.model.CityDTO;
import com.travelchronicles.repository.CityRepository;
import com.travelchronicles.repository.CountryRepository;
import com.travelchronicles.service.CityService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public void save(CityDTO cityDTO) {
        cityRepository.save(cityDTO.convertToEntity());
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public CityDTO findById(long id) {
        City city = cityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("City with id " + id + " not found"));
        return CityDTO.convertToDTO(city);
    }

    @Override
    public void deleteById(long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public void update(long id, CityDTO cityDTO) {
        City oldCity = cityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("City with id " + id + " not found"));
        oldCity.setCityName(cityDTO.cityName());
        oldCity.setFoodEaten(cityDTO.foodEaten());
        oldCity.setPlacesVisited(cityDTO.placesVisited());
        oldCity.setDaysSpent(cityDTO.daysSpent());
        oldCity.setCost(cityDTO.cost());
        cityRepository.save(oldCity);
    }

    @Override
    public void addCityToCountry(long countryId, long cityId) {
        City city = cityRepository.findById(cityId).
                orElseThrow(() -> new IllegalArgumentException("City with id " + cityId + " not found"));
        Country country = countryRepository.findById(countryId).
                orElseThrow(() -> new IllegalArgumentException("Country with id " + countryId + " not found"));

        if (city.getCountry() != null) {
            city.getCountry().getCities().remove(city);
        }

        city.setCountry(country);

        if (!country.getCities().contains(city)) {
            country.getCities().add(city);
        }

        cityRepository.save(city);
        countryRepository.save(country);
    }

    public List<City> mostExpensiveCity() {
        return cityRepository.findAllByCostDesc();
    }
}
