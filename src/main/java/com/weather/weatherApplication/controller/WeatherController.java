package com.weather.weatherApplication.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weather.weatherApplication.entity.Weather;
import com.weather.weatherApplication.entity.SaveWeatherApiData;
import com.weather.weatherApplication.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weathers")
@Slf4j
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @PostMapping
    public ResponseEntity<?> createWeather(@RequestBody Weather weather){
        Weather w = weatherService.createWeather(weather);
        return new ResponseEntity<>(w, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getWeatherList(){
        List<Weather> allWeatherList = weatherService.getAllWeatherList();
        return new ResponseEntity<>(allWeatherList,HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<?> getWeatherInfo() throws JsonProcessingException {
        SaveWeatherApiData[] weatherInfo = weatherService.saveWeatherApiData().toArray(new SaveWeatherApiData[0]);
        return new ResponseEntity<>(weatherInfo,HttpStatus.OK);
    }
}
