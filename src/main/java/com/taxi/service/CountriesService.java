package com.taxi.service;

import com.taxi.domain.Countries;
import java.util.List;

public interface CountriesService {

    public boolean add(Countries countries) throws Exception;

    public Countries findById(int id) throws Exception;

    public List<Countries> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public Countries viewById(long id) throws Exception;
}
