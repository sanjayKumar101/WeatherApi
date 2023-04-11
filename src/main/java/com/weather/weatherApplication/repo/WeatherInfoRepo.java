package com.weather.weatherApplication.repo;

import com.weather.weatherApplication.entity.WeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherInfoRepo extends JpaRepository<WeatherInfo,Integer > {
}
