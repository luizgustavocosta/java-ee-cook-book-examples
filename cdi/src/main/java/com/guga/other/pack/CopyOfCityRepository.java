package com.guga.other.pack;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.guga.ee.City;
import com.guga.ee.CityRepository;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CopyOfCityRepository {
    private static final String CITIES_FILE = "/cities.json";
    private static final List<City> cities;

    static {
        try (Reader reader = new InputStreamReader(CityRepository.class.getResourceAsStream(CITIES_FILE))) {
            Type type = new TypeToken<List<City>>() {}.getType();
            cities = new Gson().fromJson(reader, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public City findOneRandom() {
        Collections.shuffle(cities);
        return cities.stream().findFirst().orElse(null);
    }
}
