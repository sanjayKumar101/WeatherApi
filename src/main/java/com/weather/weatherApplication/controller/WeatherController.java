package com.weather.weatherApplication.controller;

import com.weather.weatherApplication.dto.WeatherDto;
import com.weather.weatherApplication.entity.Weather;
import com.weather.weatherApplication.entity.WeatherInfo;
import com.weather.weatherApplication.service.WeatherService;
import com.weather.weatherApplication.service.WeatherServiceImpl;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/weathers")
@Slf4j
public class WeatherController {

    @Autowired
    private WeatherServiceImpl weatherService;

    @PostMapping
    public ResponseEntity<?> createWeather(@RequestBody WeatherDto weatherDto){
        WeatherDto weather = weatherService.createWeather(weatherDto);
        return new ResponseEntity<>(weather, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getWeatherList(){
        List<WeatherDto> allWeatherList = weatherService.getAllWeatherList();
        return new ResponseEntity<>(allWeatherList,HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<?> getWeatherInfo(){
        WeatherInfo weatherInfo = weatherService.getWeatherInfo();
        return new ResponseEntity<>(weatherInfo,HttpStatus.OK);
    }
}
