package com.taxi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.dao.EnableOrDisableBoostingFareDao;
import com.taxi.domain.EnableOrDisableBoostingFare;
import com.taxi.service.EnableOrDisableBoostingFareService;
import java.util.List;

public class EnableOrDisableBoostingFareServicesImpl implements EnableOrDisableBoostingFareService {

    @Autowired
    EnableOrDisableBoostingFareDao boostingFareDao;

    @Override
    public List<EnableOrDisableBoostingFare> list() throws Exception {
        return boostingFareDao.list();
    }

    @Override
    public boolean update(EnableOrDisableBoostingFare enableOrDisableBoostingFare) throws Exception {
        return boostingFareDao.update(enableOrDisableBoostingFare);
    }

}
