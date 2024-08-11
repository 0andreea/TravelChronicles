package com.TravelChronicles.model;

import com.TravelChronicles.entity.Country;

public record CountryDTO(String countryName, String languageSpoken, String currency, String capital) {

    public static CountryDTO convertToDTO(Country country) {
        return new CountryDTO(country.getCountryName(), country.getLanguageSpoken(), country.getCurrency(), country.getCapital());
    }

    public Country convertToEntity() {
        Country country = new Country();
        country.setCountryName(this.countryName());
        country.setLanguageSpoken(this.languageSpoken());
        country.setCurrency(this.currency());
        country.setCapital(this.capital());
        return country;
    }
}
