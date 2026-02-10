package com.indiabulls.springbootapi.service;

import com.indiabulls.springbootapi.entity.City;
import com.indiabulls.springbootapi.entity.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CityService {
   ResponseEntity<Response> addCity(City city);
    List<City> getAllCities();
    ResponseEntity<Response> getCityById(int id);
    ResponseEntity<Response>updateCitie(City city, int id);
    ResponseEntity <Response> deleteCitie(Integer id);

}
