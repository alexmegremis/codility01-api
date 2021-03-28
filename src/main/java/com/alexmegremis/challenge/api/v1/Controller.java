package com.alexmegremis.challenge.api.v1;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    private final CitiesCountProvider countProvider;

    public Controller(final CitiesCountProvider countProvider) {this.countProvider = countProvider;}

    @GetMapping("count/{prefix}")
    public Integer getCount(@PathVariable(name = "prefix") final String prefix) {
        return countProvider.getCount(prefix);
    }
}
