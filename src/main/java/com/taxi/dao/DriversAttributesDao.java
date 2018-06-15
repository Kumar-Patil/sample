package com.taxi.dao;

import com.taxi.domain.DriverAttributes;
import java.util.List;

public interface DriversAttributesDao {

    public List<DriverAttributes> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public long add(DriverAttributes driverAttributes) throws Exception;

    public DriverAttributes findById(long id) throws Exception;

    public DriverAttributes ViewById(long id) throws Exception;

    public boolean updateStatus(long driverAttributeId) throws Exception;

    public boolean update(DriverAttributes driverAttributes) throws Exception;
}
