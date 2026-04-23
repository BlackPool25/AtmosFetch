package com.spring.atmosfetch.services;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.webmvc.autoconfigure.error.BasicErrorController;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Service
public class WeatherService {

    @Value("${weather.api.base-url}")
    private String baseUrl;

    private final LocationService locationService;

    private final RestClient restClient;

    public WeatherService(RestClient restClient, BasicErrorController basicErrorController, LocationService locationService) {
        this.restClient = restClient;
        this.locationService = locationService;
    }

    public Map<String, Object> getFlexibleForecast(MultiValueMap<String, String> params) {
        URI uri = UriComponentsBuilder
                .fromUriString(baseUrl)
                .path("/forecast")
                .queryParams(params)
                .build()
                .toUri();


        return restClient.get()
                .uri(uri)
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String, Object>>() {});
    }

}
