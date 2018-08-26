package com.taxi.dao;

import com.taxi.domain.TripsBookings;
import java.util.List;

public interface TripBookingsDao {

    public List<TripsBookings> list() throws Exception;

    public Long add(TripsBookings tripsBookings) throws Exception;

    public TripsBookings findById(long id) throws Exception;

    public boolean update(TripsBookings tripsBookings) throws Exception;
}
