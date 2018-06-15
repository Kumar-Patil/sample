package com.taxi.serviceImpl;

import com.taxi.dao.DriversAttributesDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.domain.DriverAttributes;
import com.taxi.service.DriversAttributesService;

public class DriversAttributesServicesImpl implements DriversAttributesService {

    @Autowired
    DriversAttributesDao driversAttributesDao;

    @Override
    public List<DriverAttributes> list() throws Exception {
        return driversAttributesDao.list();
    }

    @Override
    public boolean delete(long id) throws Exception {
        return driversAttributesDao.delete(id);
    }

    @Override
    public long add(DriverAttributes drivers) throws Exception {
        return driversAttributesDao.add(drivers);
    }

    @Override
    public DriverAttributes findById(long id) throws Exception {
        return driversAttributesDao.findById(id);
    }

    @Override
    public DriverAttributes viewById(long id) throws Exception {
        return driversAttributesDao.ViewById(id);
    }

    @Override
    public boolean updateStatus(long driverId) throws Exception {
        return driversAttributesDao.updateStatus(driverId);
    }

    @Override
    public boolean update(DriverAttributes driverAttributes) throws Exception {
        return driversAttributesDao.update(driverAttributes);
    }
}
