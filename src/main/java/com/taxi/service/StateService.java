package com.taxi.service;

import com.taxi.domain.States;
import com.taxi.to.State;
import java.util.List;

public interface StateService {

    public boolean add(States state) throws Exception;

    public States findById(int id) throws Exception;

    public List<State> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public States viewById(long id) throws Exception;
}
