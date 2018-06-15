package com.taxi.daoImpl;

import com.taxi.dao.*;
import static com.taxi.daoImpl.LocationsDaoImpl.LOG;
import com.taxi.domain.DriverAttributes;
import com.taxi.domain.Drivers;
import com.taxi.domain.Locations;
import com.taxi.to.DriversTo;
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

public class DriversAttributesDaoImpl implements DriversAttributesDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(DriversAttributesDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public long add(DriverAttributes driverAttributes) throws Exception {
        Long attributeId = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            attributeId = (Long) session.save(driverAttributes);
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while adding {}" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return attributeId;
    }

    @Override
    public DriverAttributes findById(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<DriverAttributes> driverAttributesList = null;
            String hql = null;
            hql = "from DriverAttributes diverAttributes where driverAttributes.driverAttribteId =:driverAttribteId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("driverAttribteId", id);
            driverAttributesList = query.list();
            tx.commit();
            if (driverAttributesList.size() > 0) {
                for (DriverAttributes driverAttributes : driverAttributesList) {
                    return driverAttributes;
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
    public List<DriverAttributes> list() throws Exception {
        List<DriverAttributes> driverAttributesList = new ArrayList<DriverAttributes>();
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            driverAttributesList = session.createCriteria(DriverAttributes.class)
                    .list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting List {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return driverAttributesList;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean delete(long id)
            throws Exception {
        try {
            session = sessionFactory.openSession();
            Object o = session.load(DriverAttributes.class, id);
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
    public DriverAttributes ViewById(long id) throws Exception {
        DriverAttributes drivers = null;
        try {
            session = sessionFactory.openSession();
            drivers = (DriverAttributes) session.load(DriverAttributes.class, id);
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
        return drivers;
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
            String hql = "UPDATE DriverAttributes driverAttributes set driverAttributes.status =:status,driverAttributes.deletedAt =:deletedAt "
                    + "WHERE driverAttributes.driverAttribteId =:driverAttribteId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("driverAttribteId", driverId);
            query.setParameter("status", 0);
            query.setParameter("deletedAt", currentTimestamp);
            query.executeUpdate();
            tx.commit();
            isStatusUpdated = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while updating DriverAttributes {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isStatusUpdated;
    }
    
    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean update(DriverAttributes driverAttributes) throws Exception {
        boolean isUpdated = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(driverAttributes);
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
