package com.taxi.dao;

import com.taxi.domain.DriverCabOnline;
import java.util.List;

public interface DriverCabOnlineDao {

    public List<DriverCabOnline> list() throws Exception;

    public Long add(DriverCabOnline driverCabOnline) throws Exception;

    public DriverCabOnline findById(long id) throws Exception;

    public boolean update(DriverCabOnline driverCabOnline) throws Exception;
}
