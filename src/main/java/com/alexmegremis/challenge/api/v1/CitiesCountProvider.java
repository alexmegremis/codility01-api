package com.alexmegremis.challenge.api.v1;

@FunctionalInterface
public interface CitiesCountProvider {
    Integer getCount(String e);
}
