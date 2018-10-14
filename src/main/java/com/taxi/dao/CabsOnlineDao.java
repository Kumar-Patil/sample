package com.taxi.dao;

import com.taxi.domain.CabsOnline;
import com.taxi.util.PolylineData;
import java.util.List;

public interface CabsOnlineDao {

    public List<PolylineData> list() throws Exception;
    public boolean update(CabsOnline cabsOnline) throws Exception;
}
