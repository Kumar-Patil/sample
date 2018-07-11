package com.taxi.serviceImpl;

import com.taxi.dao.DeliverySystemTrackingHistoryDao;
import com.taxi.domain.DeliverySystemTrackingDetails;
import com.taxi.service.DeliverySystemTrackingHistoryService;
import com.taxi.to.DeliverySystemTrackingHistoryTransfer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class DeliverySystemTrackingHistoryServiceImpl implements DeliverySystemTrackingHistoryService {

    @Autowired
    DeliverySystemTrackingHistoryDao deliverySystemTrackingHistoryDao;

    @Override
    public List<DeliverySystemTrackingHistoryTransfer> list(Long deliveryId) throws Exception {
        return deliverySystemTrackingHistoryDao.list(deliveryId);
    }

    @Override
    public boolean add(DeliverySystemTrackingDetails deliverySystemTrackingDetails) throws Exception {
        return deliverySystemTrackingHistoryDao.add(deliverySystemTrackingDetails);
    }

}
