package com.alexmegremis.challenge.api.v1;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class CitiesProviderImpl implements CitiesProvider {

    public static final String URL = "https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b6907d289e10d714a6e88b30761fae22";

    private CitiesResponseDTO response;

    @PostConstruct
    private void init() {
        WebClient.create(URL).get().retrieve().bodyToFlux(CitiesResponseDTO.class).subscribe(this :: setResponse);
    }

    @Override
    public Integer getCount(final String e) {
        if(response == null) {
            return -1;
        }
        else if(e.length() != 1) {
            throw new IllegalArgumentException("")
        }

        Integer result = response.getCities().stream().filter(c -> StringUtils.startsWithIgnoreCase(c, new String(e)));
    }

    public void setResponse(final CitiesResponseDTO response) {
        this.response = response;
        log.info(">>> Response has been set.");
    }
}
