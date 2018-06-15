package com.taxi.dao;

import com.taxi.domain.Countries;
import java.util.List;

public interface CountriesDao {

    public List<Countries> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public boolean add(Countries countries) throws Exception;

    public Countries findById(int id) throws Exception;

    public Countries ViewById(long id) throws Exception;
}
