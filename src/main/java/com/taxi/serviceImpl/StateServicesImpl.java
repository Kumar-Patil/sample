package com.taxi.serviceImpl;

import com.taxi.dao.StateDao;
import com.taxi.domain.States;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.service.StateService;
import com.taxi.to.State;

public class StateServicesImpl implements StateService {

    @Autowired
    StateDao stateDao;

    @Override
    public List<State> list() throws Exception {
        return stateDao.list();
    }

    @Override
    public boolean delete(long id) throws Exception {
        return stateDao.delete(id);
    }

    @Override
    public boolean add(States state) throws Exception {
        return stateDao.add(state);
    }

    @Override
    public States findById(int id) throws Exception {
        return stateDao.findById(id);
    }

    @Override
    public States viewById(long id) throws Exception {
        return stateDao.ViewById(id);
    }

}
