package com.taxi.dao;

import com.taxi.RequestMapper.PricingGroupsMapping;
import com.taxi.domain.PricingGroups;
import com.taxi.to.PricingGroupsTo;
import java.util.List;

public interface PricingGroupsDao {

    public List<PricingGroupsMapping> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public boolean add(PricingGroups pricingGroups) throws Exception;

    public PricingGroups findById(long id) throws Exception;

    public PricingGroupsTo ViewById(long id) throws Exception;

    public boolean updateStatus(long pricingId) throws Exception;
    
    public List<PricingGroupsTo> search(String searchVal) throws Exception;
}
