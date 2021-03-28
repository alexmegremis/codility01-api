package com.alexmegremis.challenge.api.v1;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    private final CitiesProvider citiesProvider;

    public Controller(final CitiesProvider citiesProvider) {this.citiesProvider = citiesProvider;}

    @GetMapping("count/{prefix}")
    public Integer getCount(@PathVariable(name = "prefix") final String prefix) {
        return citiesProvider.getCount(prefix);
    }
}
