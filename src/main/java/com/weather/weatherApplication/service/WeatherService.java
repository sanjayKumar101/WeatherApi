package com.weather.weatherApplication.service;

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

    public WeatherInfo getWeatherInfo(){
        String url = "http://localhost:9090/weathers";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url,String.class);
        log.info(result);

        WeatherInfo weatherInfo = new WeatherInfo();
        weatherInfo.setData(result);
        WeatherInfo save = weatherInfoRepo.save(weatherInfo);
        log.info(save.toString());
        return save;



    }

}
