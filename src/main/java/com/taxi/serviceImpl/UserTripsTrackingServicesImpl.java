package com.taxi.serviceImpl;

import com.taxi.dao.UserTripsTrackingDao;
import com.taxi.domain.UserTripsTracking;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.service.UserTripsTrackingService;
import java.util.List;

public class UserTripsTrackingServicesImpl implements UserTripsTrackingService {

    @Autowired
    UserTripsTrackingDao trackingDao;

    @Override
    public Long add(UserTripsTracking tracking) throws Exception {
        return trackingDao.add(tracking);
    }

    @Override
    public UserTripsTracking findById(long id) throws Exception {
        return trackingDao.findById(id);
    }

    @Override
    public List<UserTripsTracking> list() throws Exception {
        return trackingDao.list();
    }

    @Override
    public boolean update(UserTripsTracking tripsTracking) throws Exception {
        return trackingDao.update(tripsTracking);
    }

}
