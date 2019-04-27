package com.guga.ee.mvc.dao;

import com.guga.ee.mvc.bean.City;

import javax.annotation.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class CityDAO implements ICityDAO {

    @Override
    public List<City> findAll() {

        List<City> cities = new ArrayList<>();

        cities.add(new City(1L, "Bratislava", 432_000));
        cities.add(new City(2L, "Budapest", 1759_000));
        cities.add(new City(3L, "Prague", 1_280_000));
        cities.add(new City(4L, "Warsaw", 1_748_000));
        cities.add(new City(5L, "Los Angeles", 3_971_000));
        cities.add(new City(6L, "New York", 8_550_000));
        cities.add(new City(7L, "Edinburgh", 464_000));
        cities.add(new City(8L, "Berlin", 3_671_000));

        return cities;
    }
}