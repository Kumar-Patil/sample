package com.taxi.serviceImpl;

import com.taxi.dao.OrderTypeDao;
import com.taxi.domain.OrderType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.service.OrderTypeService;

public class OrderTypeServicesImpl implements OrderTypeService {

    @Autowired
    OrderTypeDao orderTypeDao;

    @Override
    public List<OrderType> list() throws Exception {
        return orderTypeDao.list();
    }

    @Override
    public boolean delete(long id) throws Exception {
        return orderTypeDao.delete(id);
    }

    @Override
    public boolean add(OrderType orderType) throws Exception {
        return orderTypeDao.add(orderType);
    }

    @Override
    public OrderType findById(int id) throws Exception {
        return orderTypeDao.findById(id);
    }

    @Override
    public OrderType viewById(long id) throws Exception {
        return orderTypeDao.ViewById(id);
    }

}
