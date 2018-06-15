package com.taxi.serviceImpl;

import com.taxi.RequestMapper.PricingGroupsMapping;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.dao.PricingGroupsDao;
import com.taxi.domain.PricingGroups;
import com.taxi.service.PricingGroupsService;
import com.taxi.to.PricingGroupsTo;

public class PricingGroupsServicesImpl implements PricingGroupsService {

    @Autowired
    PricingGroupsDao pricingGroupsDao;

    @Override
    public boolean delete(long id) throws Exception {
        return pricingGroupsDao.delete(id);
    }

    @Override
    public boolean add(PricingGroups pricingGroups) throws Exception {
        return pricingGroupsDao.add(pricingGroups);
    }

    @Override
    public PricingGroups findById(long id) throws Exception {
        return pricingGroupsDao.findById(id);
    }

    @Override
    public boolean updateStatus(long pricingId) throws Exception {
        return pricingGroupsDao.updateStatus(pricingId);
    }

    @Override
    public List<PricingGroupsMapping> list() throws Exception {
        return pricingGroupsDao.list();
    }

    @Override
    public PricingGroupsTo ViewById(long id) throws Exception {
        return pricingGroupsDao.ViewById(id);
    }

    @Override
    public List<PricingGroupsTo> search(String searchVal) throws Exception {
        return pricingGroupsDao.search(searchVal);
    }

}
