package com.taxi.serviceImpl;

import com.taxi.dao.TripBookingsDao;
import com.taxi.domain.TripsBookings;
import com.taxi.service.TripBokkingsService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class TripsBookingsServicesImpl implements TripBokkingsService {

    @Autowired
    TripBookingsDao tripBookingsDao;

    @Override
    public Long add(TripsBookings tripsBookings) throws Exception {
        return tripBookingsDao.add(tripsBookings);
    }

    @Override
    public TripsBookings findById(long id) throws Exception {
        return tripBookingsDao.findById(id);
    }

    @Override
    public List<TripsBookings> list() throws Exception {
        return tripBookingsDao.list();
    }

    @Override
    public boolean update(TripsBookings tripsBookings) throws Exception {
        return tripBookingsDao.update(tripsBookings);
    }

}
