package com.weather.weatherApplication.repo;

import com.weather.weatherApplication.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepo extends JpaRepository<Weather,Integer> {
}
