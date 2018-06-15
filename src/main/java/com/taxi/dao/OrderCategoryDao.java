package com.taxi.dao;

import com.taxi.domain.OrderCategory;
import java.util.List;

public interface OrderCategoryDao {

    public List<OrderCategory> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public boolean add(OrderCategory orderCategory) throws Exception;

    public OrderCategory findById(int id) throws Exception;

    public OrderCategory ViewById(long id) throws Exception;
}
