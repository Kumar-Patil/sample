package com.taxi.service;

import com.taxi.domain.CabsOnline;
import com.taxi.util.PolylineData;
import java.util.List;

public interface CabsOnlineService {
    public List<PolylineData> list() throws Exception;
    public boolean update(CabsOnline cabsOnline) throws Exception;
}
