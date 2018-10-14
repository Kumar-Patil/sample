package com.taxi.serviceImpl;

import com.taxi.dao.CabsOnlineDao;
import com.taxi.domain.CabsOnline;
import com.taxi.service.CabsOnlineService;
import com.taxi.util.PolylineData;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CabsOnlineServicesImpl implements CabsOnlineService {

    @Autowired
    CabsOnlineDao cabsOnlineDao;

    @Override
    public List<PolylineData> list() throws Exception {
        return cabsOnlineDao.list();
    }

    @Override
    public boolean update(CabsOnline cabsOnline) throws Exception {
        return cabsOnlineDao.update(cabsOnline);
    }

}
