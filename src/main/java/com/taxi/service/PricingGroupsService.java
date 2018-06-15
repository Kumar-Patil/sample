package com.taxi.service;

import com.taxi.RequestMapper.PricingGroupsMapping;
import com.taxi.domain.PricingGroups;
import com.taxi.to.PricingGroupsTo;
import java.util.List;

public interface PricingGroupsService {

    public boolean add(PricingGroups pricingGroups) throws Exception;

    public PricingGroups findById(long id) throws Exception;

    public List<PricingGroupsMapping> list() throws Exception;

    public boolean delete(long id) throws Exception;

     public PricingGroupsTo ViewById(long id) throws Exception;

    public boolean updateStatus(long pricingId) throws Exception;
    public List<PricingGroupsTo> search(String searchVal) throws Exception;
}
