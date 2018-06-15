package com.taxi.serviceImpl;

import com.taxi.dao.LocationsDao;
import com.taxi.domain.Locations;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.service.LocationsService;

public class LocationsServicesImpl implements LocationsService {

    @Autowired
    LocationsDao locationsDao;

    @Override
    public List<Locations> list() throws Exception {
        return locationsDao.list();
    }

    @Override
    public boolean delete(long id) throws Exception {
        return locationsDao.delete(id);
    }

    @Override
    public Long add(Locations locations) throws Exception {
        return locationsDao.add(locations);
    }

    @Override
    public Locations findById(long id) throws Exception {
        return locationsDao.findById(id);
    }

    @Override
    public Locations viewById(long id) throws Exception {
        return locationsDao.ViewById(id);
    }

    @Override
    public boolean update(Locations locations) throws Exception {
        return locationsDao.update(locations);
    }

}
