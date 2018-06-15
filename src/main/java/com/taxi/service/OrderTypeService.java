package com.taxi.service;

import com.taxi.domain.OrderType;
import java.util.List;

public interface OrderTypeService {

    public boolean add(OrderType orderType) throws Exception;

    public OrderType findById(int id) throws Exception;

    public List<OrderType> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public OrderType viewById(long id) throws Exception;
}
