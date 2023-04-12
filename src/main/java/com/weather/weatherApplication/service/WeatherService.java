package com.weather.weatherApplication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.weatherApplication.entity.WeatherInfo;
import com.weather.weatherApplication.repo.WeatherInfoRepo;
import com.weather.weatherApplication.repo.WeatherRepo;
import com.weather.weatherApplication.dto.WeatherDto;
import com.weather.weatherApplication.entity.Weather;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WeatherService implements WeatherServiceImpl {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private WeatherRepo weatherRepo;

    @Autowired
    private WeatherInfoRepo weatherInfoRepo;


    @Override
    public WeatherDto createWeather(WeatherDto weatherDto) {

        Weather weatherEntity = modelMapper.map(weatherDto, Weather.class);
        Weather save = weatherRepo.save(weatherEntity);
        return modelMapper.map(save,WeatherDto.class);
    }

    @Override
    public List<WeatherDto> getAllWeatherList() {
        List<Weather> all = weatherRepo.findAll();

        List<WeatherDto> collect = all.stream().map(weather -> entityToDto(weather)).collect(Collectors.toList());
        return collect;

    }

    public WeatherDto entityToDto(Weather weather) {
        return modelMapper.map(weather,WeatherDto.class);
    }

    public List<WeatherInfo> saveWeatherData() throws JsonProcessingException {
        String url = "http://localhost:9090/weathers";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url,String.class);
        log.info("result is :{}"+result);
        ObjectMapper objectMapper = new ObjectMapper();
        List<WeatherInfo> weatherList = objectMapper.readValue(result, new TypeReference<List<WeatherInfo>>(){});

        log.info("save json string into database : {}"+weatherList);
        weatherInfoRepo.saveAll(weatherList);
        return weatherList;
    }

}
