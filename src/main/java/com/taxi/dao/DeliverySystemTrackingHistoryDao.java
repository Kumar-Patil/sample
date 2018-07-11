package com.taxi.dao;

import com.taxi.domain.DeliverySystemTrackingDetails;
import com.taxi.to.DeliverySystemTrackingHistoryTransfer;
import java.util.List;

public interface DeliverySystemTrackingHistoryDao {

    public List<DeliverySystemTrackingHistoryTransfer> list(Long deliveryId) throws Exception;

    public boolean add(DeliverySystemTrackingDetails deliverySystemTrackingDetails) throws Exception ;

}
