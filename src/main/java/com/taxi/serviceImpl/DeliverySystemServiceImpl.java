package com.taxi.serviceImpl;

import com.taxi.dao.DeliverySystemDao;
import com.taxi.domain.DeliverySystem;
import com.taxi.service.DeliverySystemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class DeliverySystemServiceImpl implements DeliverySystemService {

    @Autowired
    DeliverySystemDao deliverySystemDao;

    @Override
    public List<DeliverySystem> list() throws Exception {
        return deliverySystemDao.list();
    }

    @Override
    public boolean add(DeliverySystem deliverySystem) throws Exception {
        return deliverySystemDao.add(deliverySystem);
    }

    @Override
    public DeliverySystem findById(long id) throws Exception {
        return deliverySystemDao.findById(id);
    }

    @Override
    public boolean updateStatus(long id) throws Exception {
        return deliverySystemDao.updateStatus(id);
    }

    @Override
    public boolean updateDeliveryStatus(long deliveryId, String deliveryStatus) throws Exception {
        return deliverySystemDao.updateDeliveryStatus(deliveryId, deliveryStatus);
    }

}
