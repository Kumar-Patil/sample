package com.taxi.service;

import com.taxi.domain.EnableOrDisableBoostingFare;
import com.taxi.to.EnableDisableBoostPricing;

public interface EnableOrDisableBoostingFareService {

    public EnableDisableBoostPricing list() throws Exception;
    public boolean update(EnableOrDisableBoostingFare enableOrDisableBoostingFare) throws Exception;
}
