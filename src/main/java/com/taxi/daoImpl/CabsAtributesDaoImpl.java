package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.CabAttributes;
import com.taxi.domain.Cabs;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.taxi.to.CabsTo;
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

public class CabsAtributesDaoImpl implements CabsAttributesDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(CabsAtributesDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean add(CabAttributes cabAttributes) throws Exception {
        boolean isAdded = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(cabAttributes);
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
    public CabAttributes findById(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<CabAttributes> cabAttributesList = null;
            String hql = null;
            hql = "from CabAttributes cabAttributes where cabAttributes.attributeId =:attributeId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("attributeId", id);
            cabAttributesList = query.list();
            tx.commit();
            if (cabAttributesList.size() > 0) {
                for (CabAttributes cabAttributes : cabAttributesList) {
                    return cabAttributes;
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
    public List<CabAttributes> list() throws Exception {
        List<CabAttributes> cabAttributesList = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = null;
            hql = "from CabAttributes cabAttributes where cabAttributes.status =:status";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("status", 1);
            cabAttributesList = query.list();
            tx.commit();
            if (cabAttributesList.size() > 0) {
                return cabAttributesList;
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting list {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return cabAttributesList;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean delete(long id)
            throws Exception {
        try {
            session = sessionFactory.openSession();
            Object o = session.load(CabAttributes.class, id);
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
    public CabAttributes ViewById(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<CabAttributes> cabAttributesList = null;
            String hql = null;
            hql = "from CabAttributes cabAttributes where cabAttributes.attributeId =:attributeId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("attributeId", id);
            cabAttributesList = query.list();
            tx.commit();
            if (cabAttributesList.size() > 0) {
                for (CabAttributes cabAttributes : cabAttributesList) {
                    return cabAttributes;
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
    public boolean updateStatus(long cabId) throws Exception {
        boolean isStatusUpdated = false;
        try {
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = "UPDATE CabAttributes cabAttributes set cabAttributes.status =:status,cabAttributes.deletedAt =:deletedAt "
                    + "WHERE cabAttributes.attributeId =:attributeId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("attributeId", cabId);
            query.setParameter("status", 0);
            query.setParameter("deletedAt", currentTimestamp);
            query.executeUpdate();
            tx.commit();
            isStatusUpdated = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while updating CabAttributes {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return isStatusUpdated;

    }
}
