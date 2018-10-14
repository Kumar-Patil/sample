package com.taxi.dao;

import com.taxi.domain.DeliveryProgress;
import com.taxi.util.PolylineData;
import java.util.List;

public interface DeliveryProgressDao {

    public List<PolylineData> list() throws Exception;
    public boolean update(DeliveryProgress deliveryProgress) throws Exception;
}
