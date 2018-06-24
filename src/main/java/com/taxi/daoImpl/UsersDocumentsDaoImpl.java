package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.UserDocuments;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class UsersDocumentsDaoImpl implements UserDocumentsDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(UsersDocumentsDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public long add(UserDocuments userDocuments) throws Exception {
        long documentId = 0;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            documentId = (long) session.save(userDocuments);
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while adding {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return documentId;
    }

    @Override
    public UserDocuments findById(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<UserDocuments> userDocuments = null;
            String hql = null;
            hql = "from UserDocuments userDocuments where userDocuments.userId =:userId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("userId", id);
            userDocuments = query.list();
            tx.commit();
            if (userDocuments.size() > 0) {
                for (UserDocuments driverDocuments : userDocuments) {
                    return driverDocuments;
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserDocuments> list() throws Exception {
        List<UserDocuments> userDocumentses = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            userDocumentses = session.createCriteria(UserDocuments.class)
                    .list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userDocumentses;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean delete(long id)
            throws Exception {
        try {
            session = sessionFactory.openSession();
            Object o = session.load(UserDocuments.class, id);
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
    public UserDocuments ViewById(long id) throws Exception {
        UserDocuments userDocuments = null;
        try {
            session = sessionFactory.openSession();
            userDocuments = (UserDocuments) session.load(UserDocuments.class, id);
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
        return userDocuments;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean updateStatus(long driverId) throws Exception {
        boolean isStatusUpdated = false;
        try {
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = "UPDATE UserDocuments userDocuments set userDocuments.status =:status,userDocuments.deletedAt =:deletedAt "
                    + "WHERE userDocuments.userId =:userId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("userId", driverId);
            query.setParameter("status", 0);
            query.setParameter("deletedAt", currentTimestamp);
            query.executeUpdate();
            tx.commit();
            isStatusUpdated = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while updating userDocuments {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return isStatusUpdated;

    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean update(UserDocuments userDocuments) throws Exception {
        boolean isUpdated = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(userDocuments);
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
