package com.spring.atmosfetch.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class WeatherConfig {

    @Bean
    public RestClient openMeteoClient(RestClient.Builder builder) {
        return builder
                .build();
    }
}
