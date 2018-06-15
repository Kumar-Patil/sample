package com.taxi.service;

import com.taxi.domain.DriverAttributes;
import java.util.List;

public interface DriversAttributesService {

    public long add(DriverAttributes driverAttributes) throws Exception;

    public DriverAttributes findById(long id) throws Exception;

    public List<DriverAttributes> list() throws Exception ;

    public boolean delete(long id) throws Exception;

    public DriverAttributes viewById(long id) throws Exception;
    
    public boolean updateStatus(long driverId) throws Exception;
    
    public boolean update(DriverAttributes driverAttributes) throws Exception;
}
