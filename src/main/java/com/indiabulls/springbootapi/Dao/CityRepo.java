package com.indiabulls.springbootapi.Dao;

import com.indiabulls.springbootapi.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepo extends JpaRepository<City,Integer> {
    City findByCitynameIgnoreCase(String cityname);
}
