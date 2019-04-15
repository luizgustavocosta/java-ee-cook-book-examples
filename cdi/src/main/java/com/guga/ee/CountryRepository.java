package com.guga.ee;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountryRepository {
    private static final String COUNTRIES_FILE = "/countries.json";
    private static final List<Country> countries;

    static {
        try (Reader reader = new InputStreamReader(CountryRepository.class.getResourceAsStream(COUNTRIES_FILE))) {
            Type type = new TypeToken<List<Country>>() {}.getType();
            countries = new Gson().fromJson(reader, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    List<Country> findAll() {
        return new ArrayList<>(countries);
    }
    Country findOneRandom() {
        Collections.shuffle(countries);
        return countries.stream().findFirst().orElse(null);
    }
}


