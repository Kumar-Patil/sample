package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.DriverCabOnline;
import com.taxi.domain.Locations;
import com.taxi.domain.UserOnline;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class DriverCabOnlineDaoImpl implements DriverCabOnlineDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(DriverCabOnlineDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public Long add(DriverCabOnline driverCabOnline) throws Exception {
        Long driverOnlineId = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            driverOnlineId = (Long) session.save(driverCabOnline);
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while adding {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return driverOnlineId;
    }

    @Override
    public DriverCabOnline findById(long id) throws Exception {
        DriverCabOnline driverCabOnline = null;
        try {
            session = sessionFactory.openSession();
            driverCabOnline = (DriverCabOnline) session.load(DriverCabOnline.class, id);
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
        return driverCabOnline;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DriverCabOnline> list() throws Exception {
        List<DriverCabOnline> driverCabOnlines = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            driverCabOnlines = session.createCriteria(DriverCabOnline.class)
                    .list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting list {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return driverCabOnlines;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean update(DriverCabOnline driverCabOnline) throws Exception {
        boolean isUpdated = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(driverCabOnline);
            tx.commit();
            isUpdated = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while updating {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isUpdated;
    }
}
