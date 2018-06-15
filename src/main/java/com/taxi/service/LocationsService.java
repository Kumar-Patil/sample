package com.taxi.service;

import com.taxi.domain.Locations;
import java.util.List;

public interface LocationsService {

    public Long add(Locations locations) throws Exception;

    public Locations findById(long id) throws Exception;

    public List<Locations> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public Locations viewById(long id) throws Exception;

    public boolean update(Locations locations) throws Exception;
}
