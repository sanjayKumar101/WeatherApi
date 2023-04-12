package com.weather.weatherApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "saveWeatherApiData")
public class SaveWeatherApiData {
    @Id
    private int id;
    private String cityName;
    private double temp;
}
