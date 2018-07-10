package com.taxi.dao;

import com.taxi.domain.CabAttributes;
import java.util.List;

public interface CabsAttributesDao {

    public List<CabAttributes> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public Long add(CabAttributes cabAttributes) throws Exception;

    public CabAttributes findById(long id) throws Exception;

    public CabAttributes ViewById(long id) throws Exception;

    public boolean updateStatus(long cabId) throws Exception;
    public boolean update(CabAttributes cabAttributes) throws Exception;

}
