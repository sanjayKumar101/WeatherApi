package com.weather.weatherApplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "weatherInfo")
public class WeatherInfo {
    @Id
    private int id;
    private String cityName;
    private double temp;
}
