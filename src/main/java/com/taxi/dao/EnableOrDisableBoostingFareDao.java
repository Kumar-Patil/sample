package com.taxi.dao;

import com.taxi.domain.EnableOrDisableBoostingFare;
import com.taxi.to.EnableDisableBoostPricing;

public interface EnableOrDisableBoostingFareDao {

    public EnableDisableBoostPricing list() throws Exception;
    public boolean update(EnableOrDisableBoostingFare enableOrDisableBoostingFare) throws Exception;
}
