package com.example.search.service;


import com.example.search.config.EndpointConfig;
import com.example.search.pojo.City;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final RestTemplate restTemplate;


    public WeatherServiceImpl(RestTemplate getRestTemplate) {
        this.restTemplate = getRestTemplate;
    }

    @Override
    @Async
    @Retryable(include = IllegalAccessError.class)
    public CompletableFuture<List<Integer>> findCityIdByName(String city) {
        City c = restTemplate.getForObject(EndpointConfig.queryWeatherByCity + city, City.class);
        return CompletableFuture.completedFuture(c.getWeatherInfo());
    }

    @Override
    @Async
    public CompletableFuture<Map<String, Map>> findCityNameById(int id) {
        Map<String, Map> ans = restTemplate.getForObject(EndpointConfig.queryWeatherById + id, HashMap.class);
        return CompletableFuture.completedFuture(ans);
    }

    @Override
    /**
     * Find cities' weather details given a list of cities' names
     */
    public CompletableFuture<Map<Integer, Map<String, Map>>> findCitiesWeatherByName(List<String> cities) {

        StringBuilder cityUrl =new StringBuilder().append(EndpointConfig.queryCitiesWeatherByNames);
        cityUrl.append("/search?cities=");
        for (String ct : cities){
            cityUrl.append(ct);
            cityUrl.append(",");
        }
        cityUrl.deleteCharAt(cityUrl.length() - 1);
        Map<Integer, Map<String, Map>> res = restTemplate.getForObject(cityUrl.toString(), HashMap.class);
        return CompletableFuture.completedFuture(res);

       // return null
    }

}
