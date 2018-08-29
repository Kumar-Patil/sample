package com.taxi.dao;

public interface StatisticsDao {

    public Integer totalCabsOnline(long userId) throws Exception;

    public int totalCabsAvailable(long userId) throws Exception;

    public int totalTrips(long userId) throws Exception;

    public int totalDelivery(long userId) throws Exception;

    public int totalVendorTrips(long userId) throws Exception;

    public int totalDriverTrips(long userId) throws Exception;

    public int totalRiderTrips(long userId) throws Exception;

}
