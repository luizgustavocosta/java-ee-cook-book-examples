package com.guga.ee;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.inject.Named;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//@Named
public class CityRepository {
    private static final String CITIES_FILE = "/cities.json";
    private static final List<City> cities;

    static {
        try (Reader reader = new InputStreamReader(CityRepository.class.getResourceAsStream(CITIES_FILE))) {
            Type type = new TypeToken<List<City>>() {}.getType();
            cities = new Gson().fromJson(reader, type);
            System.out.println(cities);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    List<City> findAll() {
        return new ArrayList<>(cities);
    }
    City findOneRandom() {
        Collections.shuffle(cities);
        return cities.get(0);
    }
}


