package com.taxi.service;

import com.taxi.domain.Cities;
import com.taxi.to.City;
import java.util.List;

public interface CitiesService {

    public boolean add(Cities cities) throws Exception;

    public Cities findById(int id) throws Exception;

    public List<City> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public Cities viewById(long id) throws Exception;
}
