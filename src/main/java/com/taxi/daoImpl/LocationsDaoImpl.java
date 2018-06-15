package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.Locations;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class LocationsDaoImpl implements LocationsDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(LocationsDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public Long add(Locations locations) throws Exception {
        Long locationId = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            locationId = (Long) session.save(locations);
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while adding {}" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return locationId;
    }

    @Override
    public Locations findById(long id) throws Exception {
        Locations locations = null;
        try {
            session = sessionFactory.openSession();
            locations = (Locations) session.load(Locations.class,
                    new Long(id));
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
        return locations;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Locations> list() throws Exception {
        List<Locations> locations = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            locations = session.createCriteria(Locations.class)
                    .list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return locations;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean delete(long id)
            throws Exception {
        try {
            session = sessionFactory.openSession();
            Object o = session.load(Locations.class, id);
            tx = session.getTransaction();
            session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting delete {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public Locations ViewById(long id) throws Exception {
        Locations locations = null;
        try {
            session = sessionFactory.openSession();
            locations = (Locations) session.load(Locations.class, id);
            tx = session.getTransaction();
            session.beginTransaction();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting ViewById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return locations;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean update(Locations locations) throws Exception {
        boolean isUpdated = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(locations);
            tx.commit();
            isUpdated = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while adding {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isUpdated;
    }
}
