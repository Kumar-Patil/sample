package com.taxi.dao;

import com.taxi.domain.Cabs;
import com.taxi.to.CabsTo;
import java.util.List;

public interface CabsDao {

    public List<CabsTo> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public boolean add(Cabs cabs) throws Exception;

    public CabsTo findById(long id) throws Exception;

    public CabsTo ViewById(long id) throws Exception;

    public boolean updateStatus(long cabId) throws Exception;

    public List<CabsTo> search(String searchVal) throws Exception;
    
    public List<CabsTo> listOfCabsBasedOnVendorType(long vendorId) throws Exception;
    
    public long vendorId(long id) throws Exception;
}
