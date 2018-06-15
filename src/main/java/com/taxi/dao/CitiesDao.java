package com.taxi.dao;

import com.taxi.domain.Cities;
import com.taxi.to.City;
import java.util.List;

public interface CitiesDao {

    public List<City> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public boolean add(Cities cities) throws Exception;

    public Cities findById(int id) throws Exception;

    public Cities ViewById(long id) throws Exception;
}
