package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.DeviceTokens;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class DeviceTokensDaoImpl implements DeviceTokensDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(DeviceTokensDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean add(DeviceTokens deviceTokens) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(deviceTokens);
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while adding {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public DeviceTokens findById(long id) throws Exception {
        DeviceTokens deviceTokens = null;
        try {
            session = sessionFactory.openSession();
            deviceTokens = (DeviceTokens) session.load(DeviceTokens.class, id);
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
        return deviceTokens;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DeviceTokens> list() throws Exception {
        List<DeviceTokens> deviceTokenses = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            deviceTokenses = session.createCriteria(DeviceTokens.class)
                    .list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return deviceTokenses;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean delete(long id)
            throws Exception {
        try {
            session = sessionFactory.openSession();
            Object o = session.load(DeviceTokens.class, id);
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
    public DeviceTokens ViewById(long id) throws Exception {
        DeviceTokens deviceTokens = null;
        try {
            session = sessionFactory.openSession();
            deviceTokens = (DeviceTokens) session.load(DeviceTokens.class, id);
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
        return deviceTokens;
    }
}
