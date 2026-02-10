package com.indiabulls.springbootapi.service;

import com.indiabulls.springbootapi.Dao.CityRepo;
import com.indiabulls.springbootapi.entity.City;
import com.indiabulls.springbootapi.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepo cityRepo;

    @Override
    public ResponseEntity<Response> addCity(City newCity) {
        Response response = new Response();
        try {
//            if city already exists
            City cityExists = findByCityName(newCity.getCityname());
            if (cityExists != null) {
                response.setCode(00);
                response.setMessage("City Already Exists");
                response.setData(null);
                response.setTimestamp(LocalDateTime.now());
                return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
            }

            // Save new city
            City savedCity = cityRepo.save(newCity);
            response.setCode(01);
            response.setMessage("Data Added Successfully");
            response.setData(savedCity);
            response.setTimestamp(LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(00);
            response.setMessage("Internal Server Error");
            response.setData(null);
            response.setTimestamp(LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public City findByCityName(String cityname) {
        return cityRepo.findByCitynameIgnoreCase(cityname);
    }

    @Override
    public List<City> getAllCities() {
        return cityRepo.findAll();
    }

    @Override
    public ResponseEntity<Response> getCityById(int id) {
        Response response = new Response();
        Optional<City> getCity= cityRepo.findById(id);

        if (getCity.isEmpty()) {
            response.setCode(00);
            response.setMessage("Data Not Found");
            response.setData(null);
            response.setTimestamp(LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        response.setCode(01);
        response.setMessage("Data is Found");
        response.setData(getCity.get());
        response.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<Response> updateCitie(City city, int id) {

        Response response = new Response();
        City existingCity = cityRepo.findById(id).orElse(null);

        if (existingCity == null) {
            response.setCode(00);
            response.setMessage("Data Not Found");
            response.setData(null);
            response.setTimestamp(LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        existingCity.setCityname(city.getCityname());
        existingCity.setPopulation(city.getPopulation());

        // Update city
        City updatedCity = cityRepo.save(existingCity);

        response.setCode(01);
        response.setMessage("Data Updated Successfully");
        response.setData(updatedCity);
        response.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<Response> deleteCitie(Integer id) {
        Response response = new Response();

        City city = cityRepo.findById(id).orElse(null);

        if (city == null) {
            response.setCode(00);
            response.setMessage("Data Not Found");
            response.setData(null);
            response.setTimestamp(LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

            // Delete city
            cityRepo.delete(city);

            response.setCode(01);
            response.setMessage("Data Deleted Successfully");
            response.setData(city);
            response.setTimestamp(LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

