package com.taxi.service;

import com.taxi.domain.DriverDocuments;
import java.util.List;

public interface DriversDocumentsService {

    public long add(DriverDocuments driverDocuments) throws Exception;

    public DriverDocuments findById(long id) throws Exception;

    public List<DriverDocuments> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public DriverDocuments viewById(long id) throws Exception;

    public boolean updateStatus(long driverId) throws Exception;
    
    public boolean update(DriverDocuments driverDocuments) throws Exception;
}
