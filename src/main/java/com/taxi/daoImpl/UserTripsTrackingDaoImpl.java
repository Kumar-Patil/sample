package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.Locations;
import com.taxi.domain.UserOnline;
import com.taxi.domain.UserTripsTracking;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class UserTripsTrackingDaoImpl implements UserTripsTrackingDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(UserTripsTrackingDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public Long add(UserTripsTracking tripsTracking) throws Exception {
        Long id = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            id = (Long) session.save(tripsTracking);
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while adding {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public UserTripsTracking findById(long id) throws Exception {
        UserTripsTracking userTripsTracking = null;
        try {
            session = sessionFactory.openSession();
            userTripsTracking = (UserTripsTracking) session.load(UserTripsTracking.class, id);
            tx = session.getTransaction();
            session.beginTransaction();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userTripsTracking;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserTripsTracking> list() throws Exception {
        List<UserTripsTracking> trackings = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            trackings = session.createCriteria(UserTripsTracking.class)
                    .list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting list {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return trackings;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean update(UserTripsTracking tripsTracking) throws Exception {
        boolean isUpdated = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(tripsTracking);
            tx.commit();
            isUpdated = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while update {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isUpdated;
    }
}
