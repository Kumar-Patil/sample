package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.DriverDocuments;
import com.taxi.domain.Drivers;
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

public class DriversDocumentsDaoImpl implements DriversDocumentsDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(DriversDocumentsDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public long add(DriverDocuments driverDocuments) throws Exception {
        long documentId = 0;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            documentId = (long) session.save(driverDocuments);
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
    public DriverDocuments findById(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<DriverDocuments> driverDocumentsList = null;
            String hql = null;
            hql = "from DriverDocuments driverDocuments where driverDocuments.driverDocumentId =:driverDocumentId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("driverDocumentId", id);
            driverDocumentsList = query.list();
            tx.commit();
            if (driverDocumentsList.size() > 0) {
                for (DriverDocuments driverDocuments : driverDocumentsList) {
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
    public List<DriverDocuments> list() throws Exception {
        List<DriverDocuments> driverDocumentsList = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            driverDocumentsList = session.createCriteria(Drivers.class)
                    .list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return driverDocumentsList;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean delete(long id)
            throws Exception {
        try {
            session = sessionFactory.openSession();
            Object o = session.load(DriverDocuments.class, id);
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
    public DriverDocuments ViewById(long id) throws Exception {
        DriverDocuments driverDocuments = null;
        try {
            session = sessionFactory.openSession();
            driverDocuments = (DriverDocuments) session.load(DriverDocuments.class, id);
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
        return driverDocuments;
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
            String hql = "UPDATE DriverDocuments driverDocuments set driverDocuments.status =:status,driverDocuments.deletedAt =:deletedAt "
                    + "WHERE driverDocuments.driverDocumentId =:driverDocumentId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("driverDocumentId", driverId);
            query.setParameter("status", 0);
            query.setParameter("deletedAt", currentTimestamp);
            query.executeUpdate();
            tx.commit();
            isStatusUpdated = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while updating driverDocuments {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return isStatusUpdated;

    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean update(DriverDocuments driverDocuments) throws Exception {
        boolean isUpdated = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(driverDocuments);
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
