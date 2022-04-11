package com.example.search.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public interface WeatherService {
   // List<Integer> findCityIdByName(String city);
   // Map<String, Map> findCityNameById(int id);

    CompletableFuture<List<Integer>> findCityIdByName(String city);
    CompletableFuture<Map<String, Map>> findCityNameById(int id);
    CompletableFuture<Map<Integer, Map<String, Map>>> findCitiesWeatherByName(List<String> cities);
}
