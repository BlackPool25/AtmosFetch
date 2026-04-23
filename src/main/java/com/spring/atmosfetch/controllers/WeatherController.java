package com.spring.atmosfetch.controllers;


import com.spring.atmosfetch.services.WeatherService;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/get-weather")
    public Map<String, Object> fetch() {
        MultiValueMap<String, String> query = new LinkedMultiValueMap<>();

        query.add("latitude", "13.0654");
        query.add("longitude", "77.4949");
        query.add("daily", "temperature_2m_max");
        query.add("daily", "relative_humidity_2m_max");
        query.add("timezone", "auto");

        return (Map<String, Object>) weatherService.getFlexibleForecast(query);
    }
}
