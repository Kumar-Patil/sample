package com.taxi.serviceImpl;

import com.taxi.dao.CitiesDao;
import com.taxi.domain.Cities;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.service.CitiesService;
import com.taxi.to.City;

public class CitiesServicesImpl implements CitiesService {

    @Autowired
    CitiesDao citiesDao;

    @Override
    public List<City> list() throws Exception {
        return citiesDao.list();
    }

    @Override
    public boolean delete(long id) throws Exception {
        return citiesDao.delete(id);
    }

    @Override
    public boolean add(Cities cities) throws Exception {
        return citiesDao.add(cities);
    }

    @Override
    public Cities findById(int id) throws Exception {
        return citiesDao.findById(id);
    }

    @Override
    public Cities viewById(long id) throws Exception {
        return citiesDao.ViewById(id);
    }

}
