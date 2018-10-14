package com.taxi.serviceImpl;

import com.taxi.dao.DeliveryProgressDao;
import com.taxi.domain.DeliveryProgress;
import com.taxi.service.DeliveryProgressService;
import com.taxi.util.PolylineData;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class DeliveryProgressServicesImpl implements DeliveryProgressService {

    @Autowired
    DeliveryProgressDao deliveryProgressDao;

    @Override
    public List<PolylineData> list() throws Exception {
        return deliveryProgressDao.list();
    }

    @Override
    public boolean update(DeliveryProgress deliveryProgress) throws Exception {
        return deliveryProgressDao.update(deliveryProgress);
    }

}
