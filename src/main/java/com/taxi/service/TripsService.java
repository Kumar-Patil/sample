package com.taxi.service;

import com.taxi.domain.Trips;
import com.taxi.to.TripsInProgress;
import com.taxi.util.PolylineData;
import java.util.List;

public interface TripsService {

    public Long add(Trips tripsBookings) throws Exception;

    public Trips findById(long id) throws Exception;

    public List<Trips> list() throws Exception;

    public boolean update(Trips tripsBookings) throws Exception;

    public List<TripsInProgress> tripsInProgress(long userId, String status) throws Exception;

    public List<PolylineData> polyLineData(long userId, String status) throws Exception;
}
