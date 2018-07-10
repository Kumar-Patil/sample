package com.taxi.serviceImpl;

import com.taxi.dao.CabsAttributesDao;
import com.taxi.domain.CabAttributes;
import com.taxi.service.CabsAttributesService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CabsAttributesServicesImpl implements CabsAttributesService {

    @Autowired
    CabsAttributesDao cabsAttributesDao;

    @Override
    public List<CabAttributes> list() throws Exception {
        return cabsAttributesDao.list();
    }

    @Override
    public boolean delete(long id) throws Exception {
        return cabsAttributesDao.delete(id);
    }

    @Override
    public Long add(CabAttributes cabAttributes) throws Exception {
        return cabsAttributesDao.add(cabAttributes);
    }

    @Override
    public CabAttributes findById(long id) throws Exception {
        return cabsAttributesDao.findById(id);
    }

    @Override
    public CabAttributes viewById(long id) throws Exception {
        return cabsAttributesDao.ViewById(id);
    }

    @Override
    public boolean updateStatus(long cabId) throws Exception {
        return cabsAttributesDao.updateStatus(cabId);
    }

    @Override
    public boolean update(CabAttributes cabAttributes) throws Exception {
        return cabsAttributesDao.update(cabAttributes);
    }

}
