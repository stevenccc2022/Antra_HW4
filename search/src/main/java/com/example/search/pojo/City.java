package com.example.search.pojo;

import lombok.Data;

import java.util.List;

@Data
public class City {
    private Integer cid;
    private List<Integer> weatherInfo;

    public int getCityId(){
        return cid;
    }

    public List<Integer> getWeatherInfo() {
        return weatherInfo;
    }
}
