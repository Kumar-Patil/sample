package com.taxi.daoImpl;

import com.taxi.dao.*;
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

public class UserOnlineDaoImpl implements UserOnlineDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(UserOnlineDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public Long add(UserOnline userOnline) throws Exception {
        Long userOnlineId = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            userOnlineId = (Long) session.save(userOnline);
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while adding {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userOnlineId;
    }

    @Override
    public UserOnline findById(long id) throws Exception {
        UserOnline userOnline = null;
        try {
            session = sessionFactory.openSession();
            userOnline = (UserOnline) session.load(UserOnline.class, id);
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
        return userOnline;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserOnline> list() throws Exception {
        List<UserOnline> userOnlines = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            userOnlines = session.createCriteria(Locations.class)
                    .list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userOnlines;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean update(UserOnline userOnline) throws Exception {
        boolean isUpdated = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(userOnline);
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
