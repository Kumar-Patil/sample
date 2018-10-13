package com.taxi.service;

import com.taxi.domain.EnableOrDisableBoostingFare;
import java.util.List;

public interface EnableOrDisableBoostingFareService {

    public List<EnableOrDisableBoostingFare> list() throws Exception;
    public boolean update(EnableOrDisableBoostingFare enableOrDisableBoostingFare) throws Exception;
}
