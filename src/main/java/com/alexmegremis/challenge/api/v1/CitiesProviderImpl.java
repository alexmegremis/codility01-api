package com.alexmegremis.challenge.api.v1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;

@Service
public class CitiesProviderImpl implements CitiesProvider {

    public static final String URL = "https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b6907d289e10d714a6e88b30761fae22";

    @Getter
    @Setter
    private CitiesResponseDTO response;

    @PostConstruct
    private void init() {
        WebClient.create(URL).get().retrieve().toEntity(CitiesResponseDTO.class).blockOptional().ifPresent(e -> {this.setResponse(e.getBody());});
    }

    @Override
    public Integer getCount(final Character e) {
        return 2;
    }
}
