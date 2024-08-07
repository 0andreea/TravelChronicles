package com.TravelChronicles.service;

import com.TravelChronicles.entity.Country;
import com.TravelChronicles.model.CountryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {

    void save(CountryDTO countryDTO);

    CountryDTO findById(long id);

    void deleteById(long id);

    void update(long id, CountryDTO countryDTO);

    List<Country> findAll();

}
