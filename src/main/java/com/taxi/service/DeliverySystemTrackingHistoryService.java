package com.taxi.service;

import com.taxi.domain.DeliverySystemTrackingDetails;
import com.taxi.to.DeliverySystemTrackingHistoryTransfer;
import java.util.List;

public interface DeliverySystemTrackingHistoryService {

    public List<DeliverySystemTrackingHistoryTransfer> list(Long deliveryId) throws Exception;

    public boolean add(DeliverySystemTrackingDetails deliverySystemTrackingDetails) throws Exception;

}
