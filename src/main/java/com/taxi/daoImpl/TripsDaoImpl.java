package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.Trips;
import com.taxi.to.TripsInProgress;
import com.taxi.util.PolylineData;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class TripsDaoImpl implements TripsDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(TripsDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public Long add(Trips tripsBookings) throws Exception {
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
    public Trips findById(long id) throws Exception {
        Trips tripsBookings = null;
        try {
            session = sessionFactory.openSession();
            tripsBookings = (Trips) session.load(Trips.class, id);
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
    public List<Trips> list() throws Exception {
        List<Trips> tripsBookingses = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            tripsBookingses = session.createCriteria(Trips.class)
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
    public boolean update(Trips tripsBookings) throws Exception {
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

    @Override
    public List<TripsInProgress> tripsInProgress(long userId, String status) throws Exception {
        List<Trips> trips = new ArrayList<>();
        List<TripsInProgress> inProgresses = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = null;
            hql = "from Trips trips ";
            Query query = (Query) session.createQuery(hql);
            //query.setParameter("status", status);
            trips = query.list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting tripsInProgress {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        if (trips.size() > 0) {
            for (Trips ts : trips) {
                inProgresses.add(new TripsInProgress(ts.getTripId(),
                        new Long(88),
                        "Santosh",
                        ts.getSource(),
                        ts.getDestination(), 2, 3, ts.getTrip_status()));
            }
        }
        return inProgresses;
    }

    @Override
    public List<PolylineData> polyLineData(long userId, String status) throws Exception {
        List<Trips> trips = new ArrayList<>();
        List<PolylineData> polylineDatas = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = null;
            hql = "from Trips trips ";
            Query query = (Query) session.createQuery(hql);
            //query.setParameter("status", status);
            trips = query.list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting polyLineData {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        if (trips.size() > 0) {
            for (Trips ts : trips) {
                polylineDatas.add(new PolylineData(ts.getSourceLat(), ts.getSourceLng(), "SOURCE",
                        "http://maps.google.com/mapfiles/kml/pal4/icon37.png", true));
                /*polylineDatas.add(new PolylineData(ts.getDestination_lat(), ts.getDestination_lng(), "Destination",
                        "", true));*/
            }
        }
        return polylineDatas;
    }
}
