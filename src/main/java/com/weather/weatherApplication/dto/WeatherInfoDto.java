package com.weather.weatherApplication.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherInfoDto {
    private int id;
    private String cityName;
    private double temp;
}
