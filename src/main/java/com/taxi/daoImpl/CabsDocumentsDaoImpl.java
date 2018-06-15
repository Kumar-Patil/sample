package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.CabDocuments;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class CabsDocumentsDaoImpl implements CabsDocumentsDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(CabsDocumentsDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean add(CabDocuments cabDocuments) throws Exception {
        boolean isAdded = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(cabDocuments);
            tx.commit();
            isAdded = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while adding {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isAdded;
    }

    @Override
    public CabDocuments findById(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<CabDocuments> cabDocumentsList = null;
            String hql = null;
            hql = "from CabDocuments cabDocuments where cabDocuments.documentId =:documentId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("documentId", id);
            cabDocumentsList = query.list();
            tx.commit();
            if (cabDocumentsList.size() > 0) {
                for (CabDocuments cabDocuments : cabDocumentsList) {
                    return cabDocuments;
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
    public List<CabDocuments> list() throws Exception {
        List<CabDocuments> cabDocumentsList = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = null;
            hql = "from CabDocuments cabDocuments where cabDocuments.status =:status";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("status", 1);
            cabDocumentsList = query.list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return cabDocumentsList;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean delete(long id)
            throws Exception {
        try {
            session = sessionFactory.openSession();
            Object o = session.load(CabDocuments.class, id);
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
    public CabDocuments ViewById(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<CabDocuments> cabDocumentsList = null;
            String hql = null;
            hql = "from CabDocuments cabDocuments where cabDocuments.documentId =:documentId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("documentId", id);
            cabDocumentsList = query.list();
            tx.commit();
            if (cabDocumentsList.size() > 0) {
                for (CabDocuments cabDocuments : cabDocumentsList) {
                    return cabDocuments;
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting ViewById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean updateStatus(long documentId) throws Exception {
        boolean isStatusUpdated = false;
        try {
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = "UPDATE CabDocuments cabDocuments set cabDocuments.status =:status,cabDocuments.deletedAt =:deletedAt "
                    + "WHERE cabDocuments.documentId =:documentId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("documentId", documentId);
            query.setParameter("status", 0);
            query.setParameter("deletedAt", currentTimestamp);
            query.executeUpdate();
            tx.commit();
            isStatusUpdated = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while updating Cabs {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return isStatusUpdated;

    }
}
