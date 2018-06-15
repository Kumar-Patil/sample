package com.taxi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.dao.SurgePricingDao;
import com.taxi.domain.SurgePricing;
import com.taxi.service.SurgePricingService;
import com.taxi.to.SurgePricingTo;

public class SurgePricingServicesImpl implements SurgePricingService {

    @Autowired
    SurgePricingDao surgePricingDao;

    @Override
    public boolean delete(long id) throws Exception {
        return surgePricingDao.delete(id);
    }

    @Override
    public boolean add(SurgePricing surgePricing) throws Exception {
        return surgePricingDao.add(surgePricing);
    }

    @Override
    public SurgePricingTo findById(long id) throws Exception {
        return surgePricingDao.findById(id);
    }

    @Override
    public boolean updateStatus(long pricingId) throws Exception {
        return surgePricingDao.updateStatus(pricingId);
    }

    @Override
    public List<SurgePricingTo> list() throws Exception {
        return surgePricingDao.list();
    }

    @Override
    public SurgePricingTo ViewById(long id) throws Exception {
        return surgePricingDao.ViewById(id);
    }

    @Override
    public List<SurgePricingTo> search(String searchVal) throws Exception {
        return surgePricingDao.search(searchVal);
    }

}
