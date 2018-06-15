package com.taxi.service;

import com.taxi.domain.CabAttributes;
import java.util.List;

public interface CabsAttributesService {

    public boolean add(CabAttributes cabAttributes) throws Exception;

    public CabAttributes findById(long id) throws Exception;

    public List<CabAttributes> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public CabAttributes viewById(long id) throws Exception;

    public boolean updateStatus(long cabId) throws Exception;

}
