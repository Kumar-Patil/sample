package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.Cabs;
import com.taxi.domain.SurgePricing;
import com.taxi.to.SurgePricingTo;
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

public class SurgePricingDaoImpl implements SurgePricingDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(SurgePricingDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean add(SurgePricing surgePricing) throws Exception {
        boolean isAdded = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(surgePricing);
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
    public SurgePricingTo findById(long surgeId) throws Exception {
        SurgePricingTo surgePricingTo = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<SurgePricing> surgePricingList = null;
            String hql = null;
            hql = "from SurgePricing surgePricing where surgePricing.surgeId =:surgeId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("surgeId", surgeId);
            surgePricingList = query.list();
            tx.commit();
            if (surgePricingList.size() > 0) {
                if (surgePricingList.size() > 0) {
                    for (SurgePricing surgePricing : surgePricingList) {
                        return new SurgePricingTo(
                                surgePricing.getSurgeId(),
                                surgePricing.getName(),
                                surgePricing.getStatus(),
                                surgePricing.getCreatedAt(),
                                surgePricing.getUpdatedAt(),
                                surgePricing.getDeletedAt(),
                                surgePricing.getSurgeExpiryStartDate(),
                                surgePricing.getSurgeExpiryEndDate(),
                                surgePricing.getLatitudeStart(), surgePricing.getLatitudeEnd(),
                                surgePricing.getLongitudeStart(), surgePricing.getLongitudeEnd(),
                                surgePricing.getFactor());
                    }
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return surgePricingTo;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SurgePricingTo> list() throws Exception {
        List<SurgePricing> surgePricingsList = new ArrayList<>();
        List<SurgePricingTo> surgePricingTo = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = null;
            hql = "from SurgePricing surgePricing where surgePricing.status =:status";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("status", 1);
            surgePricingsList = query.list();
            tx.commit();
            if (surgePricingsList.size() > 0) {
                for (SurgePricing surgePricing : surgePricingsList) {
                    surgePricingTo.add(new SurgePricingTo(
                            surgePricing.getSurgeId(),
                            surgePricing.getName(),
                            surgePricing.getStatus(),
                            surgePricing.getCreatedAt(),
                            surgePricing.getUpdatedAt(),
                            surgePricing.getDeletedAt(),
                            surgePricing.getSurgeExpiryStartDate(),
                            surgePricing.getSurgeExpiryEndDate(),
                            surgePricing.getLatitudeStart(), surgePricing.getLatitudeEnd(),
                            surgePricing.getLongitudeStart(), surgePricing.getLongitudeEnd(),
                            surgePricing.getFactor()));
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting list of vendors {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return surgePricingTo;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean delete(long id)
            throws Exception {
        try {
            session = sessionFactory.openSession();
            Object o = session.load(Cabs.class, id);
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
    public SurgePricingTo ViewById(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<SurgePricing> surgePricingGroupsList = null;
            String hql = null;
            hql = "from SurgePricing surgePricing where surgePricing.surgeId =:surgeId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("surgeId", id);
            surgePricingGroupsList = query.list();
            tx.commit();
            if (surgePricingGroupsList.size() > 0) {
                for (SurgePricing surgePricing : surgePricingGroupsList) {

                    return new SurgePricingTo(
                            surgePricing.getSurgeId(),
                            surgePricing.getName(),
                            surgePricing.getStatus(),
                            surgePricing.getCreatedAt(),
                            surgePricing.getUpdatedAt(),
                            surgePricing.getDeletedAt(),
                            surgePricing.getSurgeExpiryStartDate(),
                            surgePricing.getSurgeExpiryEndDate(),
                            surgePricing.getLatitudeStart(), surgePricing.getLatitudeEnd(),
                            surgePricing.getLongitudeStart(), surgePricing.getLongitudeEnd(),
                            surgePricing.getFactor());
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean updateStatus(long pricingId) throws Exception {
        boolean isStatusUpdated = false;
        try {
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = "UPDATE SurgePricing surgePricing set surgePricing.status =:status,surgePricing.deletedAt =:deletedAt "
                    + "WHERE surgePricing.surgeId =:surgeId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("surgeId", pricingId);
            query.setParameter("status", 0);
            query.setParameter("deletedAt", currentTimestamp);
            query.executeUpdate();
            tx.commit();
            isStatusUpdated = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while updating surge pricing {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return isStatusUpdated;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public List<SurgePricingTo> search(String searchVal) throws Exception {
        List<SurgePricingTo> surgePricingTo = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<SurgePricing> surgePricingList = null;
            String hql = null;
            hql = "from SurgePricing surgePricing where surgePricing.factor like "
                    + "'" + searchVal + "%' "
                    + "or surgePricing.name like '" + searchVal + "%' ";
            Query query = (Query) session.createQuery(hql);
            surgePricingList = query.list();
            tx.commit();
            if (surgePricingList.size() > 0) {
                for (SurgePricing surgePricing : surgePricingList) {
                    surgePricingTo.add(new SurgePricingTo(
                            surgePricing.getSurgeId(),
                            surgePricing.getName(),
                            surgePricing.getStatus(),
                            surgePricing.getCreatedAt(),
                            surgePricing.getUpdatedAt(),
                            surgePricing.getDeletedAt(),
                            surgePricing.getSurgeExpiryStartDate(),
                            surgePricing.getSurgeExpiryEndDate(),
                            surgePricing.getLatitudeStart(), surgePricing.getLatitudeEnd(),
                            surgePricing.getLongitudeStart(), surgePricing.getLongitudeEnd(),
                            surgePricing.getFactor()));
                }
            }

        } catch (HibernateException e) {
            LOG.error("Exception occured while getting search {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return surgePricingTo;
    }
}
