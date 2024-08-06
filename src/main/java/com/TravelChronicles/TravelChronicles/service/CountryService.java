package com.TravelChronicles.TravelChronicles.service;

import com.TravelChronicles.TravelChronicles.model.CountryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {
    void saveCountry();

    CountryDTO findById();

    List<CountryDTO> getCountries();

    void deleteCountry(long id);

    void addCityToCountry(long countryId, long cityId);

    void update(long id, CountryDTO country);
}
