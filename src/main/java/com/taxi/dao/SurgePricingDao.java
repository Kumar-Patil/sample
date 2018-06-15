package com.taxi.dao;

import com.taxi.domain.SurgePricing;
import com.taxi.to.SurgePricingTo;
import java.util.List;

public interface SurgePricingDao {

   public List<SurgePricingTo> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public boolean add(SurgePricing surgePricing) throws Exception;

    public SurgePricingTo findById(long id) throws Exception;

    public SurgePricingTo ViewById(long id) throws Exception;

    public boolean updateStatus(long pricingId) throws Exception;

    public List<SurgePricingTo> search(String searchVal) throws Exception;
}
