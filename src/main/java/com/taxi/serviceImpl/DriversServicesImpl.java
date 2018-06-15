package com.taxi.serviceImpl;

import com.taxi.RequestMapper.DriverRequestMapper;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.dao.DriversDao;
import com.taxi.domain.Drivers;
import com.taxi.service.DriversService;
import com.taxi.to.DriversTo;
import com.taxi.to.ViewDriver;

public class DriversServicesImpl implements DriversService {

    @Autowired
    DriversDao driversDao;

    @Override
    public List<DriversTo> list() throws Exception {
        return driversDao.list();
    }

    @Override
    public boolean delete(long id) throws Exception {
        return driversDao.delete(id);
    }

    @Override
    public boolean add(Drivers drivers) throws Exception {
        return driversDao.add(drivers);
    }

    @Override
    public DriverRequestMapper findById(long id) throws Exception {
        return driversDao.findById(id);
    }

    @Override
    public ViewDriver ViewById(long id) throws Exception {
        return driversDao.ViewById(id);
    }

    @Override
    public boolean updateStatus(long driverId) throws Exception {
        return driversDao.updateStatus(driverId);
    }

    @Override
    public List<DriversTo> search(String serachVal) throws Exception {
        return driversDao.search(serachVal);
    }

    @Override
    public Drivers locationId(long id) throws Exception {
        return driversDao.locationId(id);
    }

    @Override
    public List<DriversTo> listOfCabsBasedOnVendorType(long vendorId) throws Exception {
        return driversDao.listOfCabsBasedOnVendorType(vendorId);
    }

}
