package com.taxi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.dao.DriversDocumentsDao;
import com.taxi.domain.DriverDocuments;
import com.taxi.service.DriversDocumentsService;

public class DriversDocumentsServicesImpl implements DriversDocumentsService {

    @Autowired
    DriversDocumentsDao driversDocumentsDao;

    @Override
    public List<DriverDocuments> list() throws Exception {
        return driversDocumentsDao.list();
    }

    @Override
    public boolean delete(long id) throws Exception {
        return driversDocumentsDao.delete(id);
    }

    @Override
    public long add(DriverDocuments drivers) throws Exception {
        return driversDocumentsDao.add(drivers);
    }

    @Override
    public DriverDocuments findById(long id) throws Exception {
        return driversDocumentsDao.findById(id);
    }

    @Override
    public DriverDocuments viewById(long id) throws Exception {
        return driversDocumentsDao.ViewById(id);
    }

    @Override
    public boolean updateStatus(long driverAttributeId) throws Exception {
        return driversDocumentsDao.updateStatus(driverAttributeId);
    }

    @Override
    public boolean update(DriverDocuments driverDocuments) throws Exception {
        return driversDocumentsDao.update(driverDocuments);
    }

}
