package com.indiabulls.springbootapi.controller;

import com.indiabulls.springbootapi.entity.City;
import com.indiabulls.springbootapi.entity.Response;
import com.indiabulls.springbootapi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class Controller {

    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<Response> addCities(@RequestBody City newCity){
        return cityService.addCity(newCity);
    }

    @GetMapping
    public List<City> getCities(){
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response>getCityById(@PathVariable int id) {
        return cityService.getCityById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateById(@PathVariable int id, @RequestBody City newCities){
        return cityService.updateCitie(newCities,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteId(@PathVariable Integer id){
        return cityService.deleteCitie(id);
    }

}
