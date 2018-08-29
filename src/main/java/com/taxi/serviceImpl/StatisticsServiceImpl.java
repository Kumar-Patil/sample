package com.taxi.serviceImpl;

import com.taxi.dao.StatisticsDao;
import com.taxi.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author santopat
 */
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    StatisticsDao statisticsDao;

    @Override
    public Integer totalCabsOnline(long userId) throws Exception {
        return statisticsDao.totalCabsOnline(userId);
    }

    @Override
    public int totalCabsAvailable(long userId) throws Exception {
        return statisticsDao.totalCabsAvailable(userId);
    }

    @Override
    public int totalTrips(long userId) throws Exception {
        return statisticsDao.totalTrips(userId);
    }

    @Override
    public int totalDelivery(long userId) throws Exception {
        return statisticsDao.totalDelivery(userId);
    }

    @Override
    public int totalVendorTrips(long userId) throws Exception {
        return statisticsDao.totalVendorTrips(userId);
    }

    @Override
    public int totalDriverTrips(long userId) throws Exception {
        return statisticsDao.totalDriverTrips(userId);
    }

    @Override
    public int totalRiderTrips(long userId) throws Exception {
        return statisticsDao.totalRiderTrips(userId);
    }

}
