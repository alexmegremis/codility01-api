package com.alexmegremis.challenge.api.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CitiesResponseDTO {

    @JsonProperty("cnt")
    private Integer count;

    @JsonProperty("list")
    private List<CityDTO> cities;

    @Data
    static class CityDTO {
        String name;
    }
}
