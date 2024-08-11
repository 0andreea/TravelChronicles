package com.travelchronicles.model;

import com.travelchronicles.entity.City;

public record CityDTO(String cityName, String foodEaten, String placesVisited, int daysSpent, int cost) {

    public static CityDTO convertToDTO(City city) {
        return new CityDTO(city.getCityName(), city.getFoodEaten(), city.getPlacesVisited(), city.getDaysSpent(), city.getCost());
    }

    public City convertToEntity() {
        City city = new City();
        city.setCityName(this.cityName());
        city.setFoodEaten(this.foodEaten());
        city.setPlacesVisited(this.placesVisited());
        city.setDaysSpent(this.daysSpent());
        city.setCost(this.cost());
        return city;
    }
}
