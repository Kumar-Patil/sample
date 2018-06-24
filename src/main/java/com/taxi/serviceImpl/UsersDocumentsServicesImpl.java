package com.taxi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.dao.UserDocumentsDao;
import com.taxi.domain.UserDocuments;
import com.taxi.service.UsersDocumentsService;

public class UsersDocumentsServicesImpl implements UsersDocumentsService {

    @Autowired
    UserDocumentsDao userDocumentsDao;

    @Override
    public List<UserDocuments> list() throws Exception {
        return userDocumentsDao.list();
    }

    @Override
    public boolean delete(long id) throws Exception {
        return userDocumentsDao.delete(id);
    }

    @Override
    public long add(UserDocuments userDocuments) throws Exception {
        return userDocumentsDao.add(userDocuments);
    }

    @Override
    public UserDocuments findById(long id) throws Exception {
        return userDocumentsDao.findById(id);
    }

    @Override
    public UserDocuments viewById(long id) throws Exception {
        return userDocumentsDao.ViewById(id);
    }

    @Override
    public boolean updateStatus(long driverAttributeId) throws Exception {
        return userDocumentsDao.updateStatus(driverAttributeId);
    }

    @Override
    public boolean update(UserDocuments userDocuments) throws Exception {
        return userDocumentsDao.update(userDocuments);
    }

}
