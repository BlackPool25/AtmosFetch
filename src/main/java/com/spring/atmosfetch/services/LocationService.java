package com.spring.atmosfetch.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Service
public class LocationService {
    @Value("${location.api.base-url}")
    private String baseUrl;

    private final RestClient restClient;

    public LocationService(RestClient restClient) {
        this.restClient = restClient;
    }

    public Map<String, Object> getCoordinates(String locationName) {
        URI uri = UriComponentsBuilder
                .fromUriString(baseUrl)
                .queryParam("name", locationName)
                .queryParam("count", 1)
                .build()
                .toUri();

        return restClient.get()
                .uri(uri)
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String, Object>>() {
                });

    }
}
