package com.taxi.dao;

import com.taxi.domain.EnableOrDisableBoostingFare;
import java.util.List;

public interface EnableOrDisableBoostingFareDao {

    public List<EnableOrDisableBoostingFare> list() throws Exception;
    public boolean update(EnableOrDisableBoostingFare enableOrDisableBoostingFare) throws Exception;
}
