package com.taxi.serviceImpl;

import com.taxi.dao.DeviceTokensDao;
import com.taxi.domain.DeviceTokens;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.service.DeviceTokensService;

public class DeviceTokensServicesImpl implements DeviceTokensService {

    @Autowired
    DeviceTokensDao deviceTokensDao;

    @Override
    public List<DeviceTokens> list() throws Exception {
        return deviceTokensDao.list();
    }

    @Override
    public boolean delete(long id) throws Exception {
        return deviceTokensDao.delete(id);
    }

    @Override
    public boolean add(DeviceTokens deviceTokens) throws Exception {
        return deviceTokensDao.add(deviceTokens);
    }

    @Override
    public DeviceTokens findById(long id) throws Exception {
        return deviceTokensDao.findById(id);
    }

    @Override
    public DeviceTokens viewById(long id) throws Exception {
        return deviceTokensDao.ViewById(id);
    }

}
