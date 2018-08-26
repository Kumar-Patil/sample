package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.TripsBookings;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class TripsBookingsDaoImpl implements TripBookingsDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(TripsBookingsDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public Long add(TripsBookings tripsBookings) throws Exception {
        Long id = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            id = (Long) session.save(tripsBookings);
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
    public TripsBookings findById(long id) throws Exception {
        TripsBookings tripsBookings = null;
        try {
            session = sessionFactory.openSession();
            tripsBookings = (TripsBookings) session.load(TripsBookings.class, id);
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
        return tripsBookings;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TripsBookings> list() throws Exception {
        List<TripsBookings> tripsBookingses = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            tripsBookingses = session.createCriteria(TripsBookings.class)
                    .list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting list {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return tripsBookingses;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean update(TripsBookings tripsBookings) throws Exception {
        boolean isUpdated = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(tripsBookings);
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
