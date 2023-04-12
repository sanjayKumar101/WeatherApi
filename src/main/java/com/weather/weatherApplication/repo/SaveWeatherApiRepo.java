package com.weather.weatherApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaveWeatherApiRepo extends JpaRepository<com.weather.weatherApplication.entity.SaveWeatherApiData,Integer > {
}
