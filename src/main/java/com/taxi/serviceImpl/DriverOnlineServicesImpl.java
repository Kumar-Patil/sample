package com.taxi.serviceImpl;

import com.taxi.dao.DriverCabOnlineDao;
import com.taxi.domain.DriverCabOnline;
import com.taxi.service.DriverCabOnlineService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class DriverOnlineServicesImpl implements DriverCabOnlineService {

    @Autowired
    DriverCabOnlineDao driverCabOnlineDao;

    @Override
    public Long add(DriverCabOnline driverCabOnline) throws Exception {
        return driverCabOnlineDao.add(driverCabOnline);
    }

    @Override
    public DriverCabOnline findById(long id) throws Exception {
        return driverCabOnlineDao.findById(id);
    }

    @Override
    public List<DriverCabOnline> list() throws Exception {
        return driverCabOnlineDao.list();
    }

    @Override
    public boolean update(DriverCabOnline driverCabOnline) throws Exception {
        return driverCabOnlineDao.update(driverCabOnline);
    }

}
