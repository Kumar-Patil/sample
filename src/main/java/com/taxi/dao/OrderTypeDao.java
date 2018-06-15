package com.taxi.dao;

import com.taxi.domain.OrderType;
import java.util.List;

public interface OrderTypeDao {

    public List<OrderType> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public boolean add(OrderType orderType) throws Exception;

    public OrderType findById(int id) throws Exception;

    public OrderType ViewById(long id) throws Exception;
}
