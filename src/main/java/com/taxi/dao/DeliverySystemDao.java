package com.taxi.dao;

import com.taxi.domain.DeliverySystem;
import java.util.List;

public interface DeliverySystemDao {

    public List<DeliverySystem> list() throws Exception;

    public boolean add(DeliverySystem deliverySystem) throws Exception;

    public DeliverySystem findById(long id) throws Exception;

    public boolean updateStatus(long cabId) throws Exception;
    public boolean updateDeliveryStatus(long deliveryId, String deliveryStatus) throws Exception;
}
