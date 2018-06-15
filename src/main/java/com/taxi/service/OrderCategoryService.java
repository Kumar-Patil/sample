package com.taxi.service;

import com.taxi.domain.OrderCategory;
import java.util.List;

public interface OrderCategoryService {

    public boolean add(OrderCategory orderCategory) throws Exception;

    public OrderCategory findById(int id) throws Exception;

    public List<OrderCategory> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public OrderCategory viewById(long id) throws Exception;
}
