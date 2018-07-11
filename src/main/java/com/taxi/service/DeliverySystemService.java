package com.taxi.service;

import com.taxi.domain.DeliverySystem;
import com.taxi.to.DeliverySystemTransfer;
import java.util.List;

public interface DeliverySystemService {

    public List<DeliverySystemTransfer> list() throws Exception;

    public boolean add(DeliverySystem deliverySystem) throws Exception;

    public DeliverySystem findById(long id) throws Exception;

    public boolean updateStatus(long id) throws Exception;

    public boolean updateDeliveryStatus(long deliveryId, String deliveryStatus) throws Exception;
}
