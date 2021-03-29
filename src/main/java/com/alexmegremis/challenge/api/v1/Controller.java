package com.alexmegremis.challenge.api.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class Controller {

    private final CitiesCountProvider countProvider;

    public Controller(final CitiesCountProvider countProvider) {this.countProvider = countProvider;}

    @CrossOrigin(origins = "*")
    @GetMapping("count/{prefix}")
    public Integer getCount(@PathVariable(name = "prefix") final String prefix) {
        Integer result = countProvider.getCount(prefix);
        log.info(">>> returning {} for {}", result, prefix);
        return result;
    }
}
