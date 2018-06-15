package com.taxi.serviceImpl;

import com.taxi.RequestMapper.VendorRequestMapper;
import com.taxi.dao.VendorsDao;
import com.taxi.domain.Vendors;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.service.VendorsService;
import com.taxi.to.VendorsTo;
import com.taxi.to.ViewVendorTo;

public class VendorsServicesImpl implements VendorsService {

    @Autowired
    VendorsDao vendorsDao;

    @Override
    public List<VendorsTo> list() throws Exception {
        return vendorsDao.list();
    }

    @Override
    public boolean delete(long id) throws Exception {
        return vendorsDao.delete(id);
    }

    @Override
    public boolean add(Vendors vendors) throws Exception {
        return vendorsDao.add(vendors);
    }

    @Override
    public VendorRequestMapper findById(long id) throws Exception {
        return vendorsDao.findById(id);
    }

    @Override
    public ViewVendorTo viewById(long id) throws Exception {
        return vendorsDao.ViewById(id);
    }

    @Override
    public boolean updateStatus(long vendorId) throws Exception {
        return vendorsDao.updateStatus(vendorId);
    }

    @Override
    public Vendors details(long id) throws Exception {
         return vendorsDao.details(id);
    }

    @Override
    public List<VendorsTo> search(String searchVal) throws Exception {
        return vendorsDao.search(searchVal);
    }

}
