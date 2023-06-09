package com.weather.weatherApplication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.weatherApplication.entity.SaveWeatherApiData;
import com.weather.weatherApplication.repo.SaveWeatherApiRepo;
import com.weather.weatherApplication.repo.WeatherRepo;
import com.weather.weatherApplication.entity.Weather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class WeatherService {

    @Autowired
    private WeatherRepo weatherRepo;

    @Autowired
    private SaveWeatherApiRepo saveWeatherApiData;

    public Weather createWeather(Weather weather) {
        Weather save = weatherRepo.save(weather);
        return save;
    }

    public List<Weather> getAllWeatherList() {
        List<Weather> all = weatherRepo.findAll();
        return all;
    }


    public List<SaveWeatherApiData> saveWeatherApiData() throws JsonProcessingException {
        String url = "http://localhost:9090/weathers";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url,String.class);
        log.info("result is :{}"+result);
        ObjectMapper objectMapper = new ObjectMapper();
        List<SaveWeatherApiData> weatherList = objectMapper.readValue(result, new TypeReference<List<SaveWeatherApiData>>(){});

        log.info("save json string into database : {}"+weatherList);
        saveWeatherApiData.saveAll(weatherList);
        return weatherList;
    }

}
