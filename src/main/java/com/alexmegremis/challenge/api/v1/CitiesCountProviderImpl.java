package com.alexmegremis.challenge.api.v1;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CitiesCountProviderImpl implements CitiesCountProvider {

    private CitiesDataProvider dataProvider;

    @Override
    public Integer getCount(final String input) {
        final List<String> cities = dataProvider.getCities();

        // this should never happen
        if (input == null || input.length() != 1) {
            throw new IllegalArgumentException("Input must be single character.");
        }
        if (CollectionUtils.isEmpty(cities)) {
            throw new IllegalStateException("City list has not been initialized.");
        }

        Integer result = Math.toIntExact(cities.stream().filter(c -> StringUtils.startsWithIgnoreCase(c, input)).count());

        return result;
    }
}
