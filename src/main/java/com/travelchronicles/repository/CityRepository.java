package com.travelchronicles.repository;

import com.travelchronicles.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query("SELECT c FROM City c ORDER BY c.cost DESC")
    List<City> findAllByCostDesc();
}
