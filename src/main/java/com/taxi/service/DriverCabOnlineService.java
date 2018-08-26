package com.taxi.service;

import com.taxi.domain.DriverCabOnline;
import java.util.List;

public interface DriverCabOnlineService {

    public Long add(DriverCabOnline driverCabOnline) throws Exception;

    public DriverCabOnline findById(long id) throws Exception;

    public List<DriverCabOnline> list() throws Exception;

    public boolean update(DriverCabOnline driverCabOnline) throws Exception;
}
