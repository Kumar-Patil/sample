package com.taxi.serviceImpl;

import com.taxi.dao.UserOnlineDao;
import com.taxi.domain.UserOnline;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.service.UserOnlineService;

public class UserOnlineServicesImpl implements UserOnlineService {

    @Autowired
    UserOnlineDao userOnlineDao;

    @Override
    public Long add(UserOnline userOnline) throws Exception {
        return userOnlineDao.add(userOnline);
    }

    @Override
    public UserOnline findById(long id) throws Exception {
        return userOnlineDao.findById(id);
    }

    @Override
    public List<UserOnline> list() throws Exception {
        return userOnlineDao.list();
    }

    @Override
    public boolean update(UserOnline userOnline) throws Exception {
        return userOnlineDao.update(userOnline);
    }

}
