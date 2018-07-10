package com.taxi.serviceImpl;

import com.taxi.dao.CabsDocumentsDao;
import com.taxi.domain.CabDocuments;
import com.taxi.service.CabsDocumentsService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CabsDocumentsServicesImpl implements CabsDocumentsService {

    @Autowired
    CabsDocumentsDao cabsDocumentsDao;

    @Override
    public List<CabDocuments> list() throws Exception {
        return cabsDocumentsDao.list();
    }

    @Override
    public boolean delete(long id) throws Exception {
        return cabsDocumentsDao.delete(id);
    }

    @Override
    public Long add(CabDocuments cabDocuments) throws Exception {
        return cabsDocumentsDao.add(cabDocuments);
    }

    @Override
    public CabDocuments findById(long id) throws Exception {
        return cabsDocumentsDao.findById(id);
    }

    @Override
    public CabDocuments viewById(long id) throws Exception {
        return cabsDocumentsDao.ViewById(id);
    }

    @Override
    public boolean updateStatus(long cabId) throws Exception {
        return cabsDocumentsDao.updateStatus(cabId);
    }

    @Override
    public boolean update(CabDocuments cabDocuments) throws Exception {
        return cabsDocumentsDao
                .update(cabDocuments);
    }

}
