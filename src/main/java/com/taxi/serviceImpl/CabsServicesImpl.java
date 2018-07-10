package com.taxi.serviceImpl;

import com.taxi.RequestMapper.CabsRequestMapping;
import com.taxi.dao.CabsDao;
import com.taxi.domain.Cabs;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.service.CabsService;
import com.taxi.to.CabsTo;
import com.taxi.to.CabsViewTo;

public class CabsServicesImpl implements CabsService {

    @Autowired
    CabsDao cabsDao;

    @Override
    public List<CabsTo> list() throws Exception {
        return cabsDao.list();
    }

    @Override
    public boolean delete(long id) throws Exception {
        return cabsDao.delete(id);
    }

    @Override
    public boolean add(Cabs cabs) throws Exception {
        return cabsDao.add(cabs);
    }

    @Override
    public Cabs findById(long id) throws Exception {
        return cabsDao.findById(id);
    }

    @Override
    public CabsTo viewById(long id) throws Exception {
        return cabsDao.ViewById(id);
    }

    @Override
    public boolean updateStatus(long cabId) throws Exception {
        return cabsDao.updateStatus(cabId);
    }

    @Override
    public List<CabsTo> search(String searchVal) throws Exception {
        return cabsDao.search(searchVal);
    }

    @Override
    public List<CabsTo> listOfCabsBasedOnVendorType(long vendorId) throws Exception {
        return cabsDao.listOfCabsBasedOnVendorType(vendorId);
    }

    @Override
    public long vendorId(long id) throws Exception {
        return cabsDao.vendorId(id);
    }

    @Override
    public CabsRequestMapping details(long id) throws Exception {
        return cabsDao.details(id);
    }

    @Override
    public CabsViewTo view(long id) throws Exception {
         return cabsDao.view(id);
    }

}
