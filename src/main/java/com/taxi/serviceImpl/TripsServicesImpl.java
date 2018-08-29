package com.taxi.serviceImpl;

import com.taxi.domain.Trips;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.taxi.dao.TripsDao;
import com.taxi.service.TripsService;
import com.taxi.to.TripsInProgress;

public class TripsServicesImpl implements TripsService {

    @Autowired
    TripsDao tripBookingsDao;

    @Override
    public Long add(Trips tripsBookings) throws Exception {
        return tripBookingsDao.add(tripsBookings);
    }

    @Override
    public Trips findById(long id) throws Exception {
        return tripBookingsDao.findById(id);
    }

    @Override
    public List<Trips> list() throws Exception {
        return tripBookingsDao.list();
    }

    @Override
    public boolean update(Trips tripsBookings) throws Exception {
        return tripBookingsDao.update(tripsBookings);
    }

    @Override
    public List<TripsInProgress> tripsInProgress(long userId, String status) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
