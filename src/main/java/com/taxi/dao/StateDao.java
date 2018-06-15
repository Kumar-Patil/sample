package com.taxi.dao;

import com.taxi.domain.States;
import com.taxi.to.State;
import java.util.List;

public interface StateDao {

    public List<State> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public boolean add(States state) throws Exception;

    public States findById(int id) throws Exception;

    public States ViewById(long id) throws Exception;
}
