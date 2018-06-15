package com.taxi.dao;

import com.taxi.RequestMapper.VendorRequestMapper;
import com.taxi.domain.Vendors;
import com.taxi.to.VendorsTo;
import com.taxi.to.ViewVendorTo;
import java.util.List;

public interface VendorsDao {

    public List<VendorsTo> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public boolean add(Vendors vendors) throws Exception;

    public VendorRequestMapper findById(long id) throws Exception;

    public Vendors details(long id) throws Exception;

    public ViewVendorTo ViewById(long id) throws Exception;

    public boolean updateStatus(long vendorId) throws Exception;
    
    public List<VendorsTo> search(String searchVal) throws Exception;
}
