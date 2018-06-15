package com.taxi.dao;

import com.taxi.domain.Locations;
import java.util.List;

public interface LocationsDao {

    public List<Locations> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public Long add(Locations locations) throws Exception;

    public Locations findById(long id) throws Exception;

    public Locations ViewById(long id) throws Exception;
    
    public boolean update(Locations locations) throws Exception;
}
