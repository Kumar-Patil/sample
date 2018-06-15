package com.taxi.serviceImpl;

import com.taxi.dao.OrderCategoryDao;
import com.taxi.domain.OrderCategory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.service.OrderCategoryService;

public class OrderCategoryServicesImpl implements OrderCategoryService {

    @Autowired
    OrderCategoryDao orderCategoryDao;

    @Override
    public List<OrderCategory> list() throws Exception {
        return orderCategoryDao.list();
    }

    @Override
    public boolean delete(long id) throws Exception {
        return orderCategoryDao.delete(id);
    }

    @Override
    public boolean add(OrderCategory orderCategory) throws Exception {
        return orderCategoryDao.add(orderCategory);
    }

    @Override
    public OrderCategory findById(int id) throws Exception {
        return orderCategoryDao.findById(id);
    }

    @Override
    public OrderCategory viewById(long id) throws Exception {
        return orderCategoryDao.ViewById(id);
    }

}
