package com.alexmegremis.challenge.api.v1;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OpenWeatherCitiesDataProviderImpl implements CitiesDataProvider {

    public static final String URL = "https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b6907d289e10d714a6e88b30761fae22";

    @Getter
    private List<String> cities;

    @PostConstruct
    private void init() {
        WebClient.create(URL).get().retrieve().bodyToFlux(CitiesResponseDTO.class).subscribe(this :: handleResponse);
    }

    public void handleResponse(final CitiesResponseDTO response) {
        this.cities = response.getCities()
                              .stream()
                              .map(CitiesResponseDTO.CityDTO :: getName)
                              .collect(Collectors.toList());

        log.info(">>> OpenWeatherMap response has been set.");
    }
}
