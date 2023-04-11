package com.weather.weatherApplication.dto;

import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherDto {

    private int id;
    private String cityName;
    private double temp;

}
