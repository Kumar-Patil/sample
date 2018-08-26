package com.taxi.service;

import com.taxi.domain.TripsBookings;
import java.util.List;

public interface TripBokkingsService {

    public Long add(TripsBookings tripsBookings) throws Exception;

    public TripsBookings findById(long id) throws Exception;

    public List<TripsBookings> list() throws Exception;

    public boolean update(TripsBookings tripsBookings) throws Exception;
}
