package com.taxi.dao;

import com.taxi.domain.DriverDocuments;
import java.util.List;

public interface DriversDocumentsDao {

    public List<DriverDocuments> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public long add(DriverDocuments driverDocuments) throws Exception;

    public DriverDocuments findById(long id) throws Exception;

    public DriverDocuments ViewById(long id) throws Exception;

    public boolean updateStatus(long driverId) throws Exception;
    
    public boolean update(DriverDocuments driverDocuments) throws Exception;
}
