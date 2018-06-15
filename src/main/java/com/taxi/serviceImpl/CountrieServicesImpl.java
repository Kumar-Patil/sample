package com.taxi.serviceImpl;

import com.taxi.domain.Countries;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.service.CountriesService;
import com.taxi.dao.CountriesDao;

public class CountrieServicesImpl implements CountriesService {

    @Autowired
    CountriesDao countriesDao;

    @Override
    public List<Countries> list() throws Exception {
        return countriesDao.list();
    }

    @Override
    public boolean delete(long id) throws Exception {
        return countriesDao.delete(id);
    }

    @Override
    public boolean add(Countries countries) throws Exception {
        return countriesDao.add(countries);
    }

    @Override
    public Countries findById(int id) throws Exception {
        return countriesDao.findById(id);
    }

    @Override
    public Countries viewById(long id) throws Exception {
        return countriesDao.ViewById(id);
    }

}
