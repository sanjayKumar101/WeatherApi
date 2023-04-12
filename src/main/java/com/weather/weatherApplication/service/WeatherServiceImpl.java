package com.weather.weatherApplication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weather.weatherApplication.dto.WeatherDto;
import com.weather.weatherApplication.entity.WeatherInfo;

import java.util.List;

public interface WeatherServiceImpl {

    //create weather
    WeatherDto createWeather(WeatherDto weatherDto);

    //get weather list
    List<WeatherDto> getAllWeatherList();


    List<WeatherInfo> saveWeatherData() throws JsonProcessingException;


}
