package com.guga.ee.mvc.service;

import com.guga.ee.mvc.bean.City;
import com.guga.ee.mvc.dao.ICityDAO;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
public class CityService implements ICityService {

    @Inject
    private ICityDAO cityDao;

    @Override
    public List<City> getCities() {

        return cityDao.findAll();
    }
}
