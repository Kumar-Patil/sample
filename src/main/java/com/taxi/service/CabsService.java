package com.taxi.service;

import com.taxi.RequestMapper.CabsRequestMapping;
import com.taxi.domain.Cabs;
import com.taxi.to.CabsTo;
import com.taxi.to.CabsViewTo;
import java.util.List;

public interface CabsService {

    public boolean add(Cabs cabs) throws Exception;

    public Cabs findById(long id) throws Exception;

    public List<CabsTo> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public CabsTo viewById(long id) throws Exception;

    public boolean updateStatus(long cabId) throws Exception;

    public List<CabsTo> search(String searchVal) throws Exception;

    public List<CabsTo> listOfCabsBasedOnVendorType(long vendorId) throws Exception;

    public long vendorId(long id) throws Exception;

    public CabsRequestMapping details(long id) throws Exception;

    public CabsViewTo view(long id) throws Exception;
}
