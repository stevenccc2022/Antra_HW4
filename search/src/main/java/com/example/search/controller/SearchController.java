package com.example.search.controller;

import com.example.search.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class SearchController {
    private WeatherService weatherService;


    @Autowired
    public SearchController(WeatherService searchService) {
        this.weatherService = searchService;
    }

    @GetMapping("/weather/search")
    public CompletableFuture<ResponseEntity<?>> getDetails(@RequestParam(required = true) String city) {
        //TODO
        return weatherService.findCityIdByName(city).thenApply(ResponseEntity :: ok);
    }

    @GetMapping("/weather/details/{id}")
    public CompletableFuture<ResponseEntity<?>> getWeatherDetailsByCityID(@PathVariable int id) {
        return weatherService.findCityNameById(id).thenApply(ResponseEntity :: ok);
    }

    @GetMapping("/weather/details")
    public CompletableFuture<ResponseEntity<?>> getCitiesWeatherDetails(@RequestParam(required = true) List<String> cities) {
        return weatherService.findCitiesWeatherByName(cities).thenApply(ResponseEntity :: ok);
    }

}
