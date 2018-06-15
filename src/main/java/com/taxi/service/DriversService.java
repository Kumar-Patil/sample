package com.taxi.service;

import com.taxi.RequestMapper.DriverRequestMapper;
import com.taxi.domain.Drivers;
import com.taxi.to.DriversTo;
import com.taxi.to.ViewDriver;
import java.util.List;

public interface DriversService {

    public boolean add(Drivers drivers) throws Exception;

    public DriverRequestMapper findById(long id) throws Exception;

    public List<DriversTo> list() throws Exception ;

    public boolean delete(long id) throws Exception;

    public ViewDriver ViewById(long id) throws Exception;
    
    public boolean updateStatus(long driverId) throws Exception;
    
    public List<DriversTo> search(String serachVal) throws Exception;
    
    public Drivers locationId(long id) throws Exception;
    
    public List<DriversTo> listOfCabsBasedOnVendorType(long vendorId) throws Exception;
}
