package com.taxi.service;

import com.taxi.domain.UserTripsTracking;
import java.util.List;

public interface UserTripsTrackingService {

    public Long add(UserTripsTracking tracking) throws Exception;

    public UserTripsTracking findById(long id) throws Exception;

    public List<UserTripsTracking> list() throws Exception;

    public boolean update(UserTripsTracking tripsTracking) throws Exception;
}
