package com.taxi.service;

import com.taxi.domain.DeliverySystem;
import java.util.List;

public interface DeliverySystemService {

    public List<DeliverySystem> list() throws Exception;

    public boolean add(DeliverySystem deliverySystem) throws Exception;

    public DeliverySystem findById(long id) throws Exception;

    public boolean updateStatus(long id) throws Exception;
}
