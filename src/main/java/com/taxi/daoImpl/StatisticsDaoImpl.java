package com.taxi.daoImpl;

import com.taxi.dao.StatisticsDao;
import com.taxi.dao.UserDao;
import com.taxi.util.Constants;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author santopat
 */
public class StatisticsDaoImpl implements StatisticsDao {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    UserDao userDao;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(StatisticsDaoImpl.class);

    @Override
    public Integer totalCabsOnline(long userId) throws Exception {
        Integer recordCount = 0;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String sqlCountQuery = null;
            String roleType = userDao.getRoleType(userId);
            if (roleType.equalsIgnoreCase(Constants.SUPREME_USER) || roleType.equalsIgnoreCase(Constants.VIEW_USER)) {
                sqlCountQuery = "SELECT count(*) as CAB_ONLINE_COUNT"  + " FROM driver_cab_online "
                        + "where is_online=1";
            } else {
                sqlCountQuery = "SELECT count(*) as CAB_ONLINE_COUNT "
                        + "FROM driver_cab_online "
                        + "where is_online=1 and user_id in "
                        + "(select user_vendor_id from user_mapping where user_id = " + userId + " )";
            }
            SQLQuery sqlQuery = session.createSQLQuery(sqlCountQuery);
            sqlQuery.addScalar("CAB_ONLINE_COUNT", StandardBasicTypes.INTEGER);
            recordCount = (Integer) sqlQuery.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting totalCabsOnline {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return recordCount;
    }

    @Override
    public int totalCabsAvailable(long userId) throws Exception {
        Integer recordCount = 0;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String sqlCountQuery = null;
            String roleType = userDao.getRoleType(userId);
            if (roleType.equalsIgnoreCase(Constants.SUPREME_USER) || roleType.equalsIgnoreCase(Constants.VIEW_USER)) {
                sqlCountQuery = "SELECT count(*) as CAB_AVAILABLE_COUNT "
                        + "FROM driver_cab_online "
                        + "where is_online=1 and is_on_trip = 0";
            } else {
                sqlCountQuery = "SELECT count(*) as CAB_AVAILABLE_COUNT "
                        + "FROM driver_cab_online "
                        + "where is_online=1 and is_on_trip = 0 user_id in "
                        + "(select user_vendor_id from user_mapping where user_id = " + userId + " )";
            }
            SQLQuery sqlQuery = session.createSQLQuery(sqlCountQuery);
            sqlQuery.addScalar("CAB_AVAILABLE_COUNT", StandardBasicTypes.INTEGER);
            recordCount = (Integer) sqlQuery.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting totalCabsAvailable {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return recordCount;
    }

    @Override
    public int totalTrips(long userId) throws Exception {
        Integer recordCount = 0;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String sqlCountQuery = null;
            String roleType = userDao.getRoleType(userId);
            if (roleType.equalsIgnoreCase(Constants.SUPREME_USER) || roleType.equalsIgnoreCase(Constants.VIEW_USER)) {
                sqlCountQuery = "SELECT count(*) as TRIPS_COMPLETED_COUNT FROM trips "
                        + "WHERE trip_status='completed' AND (`last_updated_at` > "
                        + "DATE_SUB(now(), INTERVAL 1 DAY));";
            } else {
                sqlCountQuery = "SELECT count(*) as TRIPS_COMPLETED_COUNT FROM trips "
                        + "WHERE trip_status='completed' AND "
                        + "(last_updated_at > DATE_SUB(now(), INTERVAL 1 DAY))"
                        + "(select user_vendor_id from user_mapping where user_id = " + userId + " )";
            }
            SQLQuery sqlQuery = session.createSQLQuery(sqlCountQuery);
            sqlQuery.addScalar("TRIPS_COMPLETED_COUNT", StandardBasicTypes.INTEGER);
            recordCount = (Integer) sqlQuery.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting totalTrips {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return recordCount;
    }

    @Override
    public int totalDelivery(long userId) throws Exception {
        Integer recordCount = 0;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String sqlCountQuery = null;
            String roleType = userDao.getRoleType(userId);
            if (roleType.equalsIgnoreCase(Constants.SUPREME_USER) || roleType.equalsIgnoreCase(Constants.VIEW_USER)) {
                sqlCountQuery = "SELECT count(*) as DELIVERY_COMPLETED_COUNT FROM delivery_system "
                        + "WHERE delivery_current_status='completed' "
                        + "AND (`delevery_completed_at` > DATE_SUB(now(), INTERVAL 1 DAY)) ";
            } else {
                sqlCountQuery = "SELECT count(*) as DELIVERY_COMPLETED_COUNT FROM delivery_system "
                        + "WHERE delivery_current_status='completed' "
                        + "AND (`delevery_completed_at` > DATE_SUB(now(), INTERVAL 1 DAY)) "
                        + "(select user_vendor_id from user_mapping where user_id = " + userId + " )";
            }
            SQLQuery sqlQuery = session.createSQLQuery(sqlCountQuery);
            sqlQuery.addScalar("DELIVERY_COMPLETED_COUNT", StandardBasicTypes.INTEGER);
            recordCount = (Integer) sqlQuery.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting totalDelivery {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return recordCount;
    }

    @Override
    public int totalVendorTrips(long userId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int totalDriverTrips(long userId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int totalRiderTrips(long userId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
