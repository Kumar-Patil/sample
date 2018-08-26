package com.taxi.dao;

import com.taxi.domain.UserTripsTracking;
import java.util.List;

public interface UserTripsTrackingDao {

    public List<UserTripsTracking> list() throws Exception;

    public Long add(UserTripsTracking userTripsTracking) throws Exception;

    public UserTripsTracking findById(long id) throws Exception;

    public boolean update(UserTripsTracking userTripsTracking) throws Exception;
}
