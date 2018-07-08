package com.taxi.daoImpl;

import com.taxi.RequestMapper.PricingGroupsMapping;
import com.taxi.dao.*;
import com.taxi.domain.Cabs;
import com.taxi.domain.PricingGroups;
import com.taxi.to.PricingGroupsTo;
import com.taxi.to.PricingTo;
import com.taxi.util.Constants;
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

public class PricingGroupsDaoImpl implements PricingGroupsDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(PricingGroupsDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean add(PricingGroups pricingGroups) throws Exception {
        boolean isAdded = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(pricingGroups);
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
    public PricingGroups findById(long id) throws Exception {
        PricingGroups pricingGroups = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<PricingGroups> priceList = null;
            String hql = null;
            hql = "from PricingGroups pricingGroups where pricingGroups.pricingId =:pricingId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("pricingId", id);
            priceList = query.list();
            tx.commit();
            if (priceList.size() > 0) {
                for (PricingGroups pricingGroups1 : priceList) {
                    return pricingGroups1;
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return pricingGroups;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PricingTo> list() throws Exception {
        List<PricingTo> pricingGroupsLists = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<PricingGroups> pricingGroupsList = null;
            String hql = null;
            hql = "from PricingGroups pricingGroups where pricingGroups.status =:status";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("status", 1);
            pricingGroupsList = query.list();
            tx.commit();
            if (pricingGroupsList.size() > 0) {
                for (PricingGroups pricingGroups : pricingGroupsList) {
                    pricingGroupsLists.add(new PricingTo(pricingGroups.getPricingId(),
                            Constants.status().get(pricingGroups.getStatus()), pricingGroups.getPricePerUnitDistance(),
                            pricingGroups.getPricePerMinute(),
                            pricingGroups.getVendors().getVendorId(),
                            pricingGroups.getName(), pricingGroups.getVendors().getFirstName(), pricingGroups.getVendors().getVendorRegistrationNo()));
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting list of vendors {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return pricingGroupsLists;
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
    public PricingGroupsTo ViewById(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<PricingGroups> pricingGroupsList = null;
            String hql = null;
            hql = "from PricingGroups pricingGroups where pricingGroups.pricingId =:pricingId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("pricingId", id);
            pricingGroupsList = query.list();
            tx.commit();
            if (pricingGroupsList.size() > 0) {
                for (PricingGroups pricingGroups : pricingGroupsList) {
                    return new PricingGroupsTo(pricingGroups.getCreatedAt(),
                            pricingGroups.getUpdatedAt(), pricingGroups.getDeletedAt(), pricingGroups.getPricingId(),
                            pricingGroups.getStatus(), pricingGroups.getPricePerUnitDistance(),
                            pricingGroups.getPricePerMinute(),
                            pricingGroups.getVendors().getVendorId(), pricingGroups.getName(), pricingGroups.getVendors().getFirstName());
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
            String hql = "UPDATE PricingGroups pricingGroups set pricingGroups.status =:status,pricingGroups.deletedAt =:deletedAt "
                    + "WHERE pricingGroups.pricingId =:pricingId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("pricingId", pricingId);
            query.setParameter("status", 0);
            query.setParameter("deletedAt", currentTimestamp);
            query.executeUpdate();
            tx.commit();
            isStatusUpdated = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while updating vendor {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return isStatusUpdated;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public List<PricingGroupsTo> search(String searchVal) throws Exception {
        List<PricingGroupsTo> pricingGroupsToTo = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<PricingGroups> pricingGroupsList = null;
            String hql = null;
            hql = "from PricingGroups pricingGroups where pricingGroups.pricePerUnitDistance like "
                    + "'" + searchVal + "%' "
                    + "or pricingGroups.name like '" + searchVal + "%' ";
            Query query = (Query) session.createQuery(hql);
            pricingGroupsList = query.list();
            tx.commit();
            if (pricingGroupsList.size() > 0) {
                for (PricingGroups pricingGroups : pricingGroupsList) {
                    pricingGroupsToTo.add(new PricingGroupsTo(pricingGroups.getCreatedAt(),
                            pricingGroups.getUpdatedAt(), pricingGroups.getDeletedAt(), pricingGroups.getPricingId(),
                            pricingGroups.getStatus(), pricingGroups.getPricePerUnitDistance(),
                            pricingGroups.getPricePerMinute(),
                            pricingGroups.getVendors().getVendorId(), pricingGroups.getName(), pricingGroups.getVendors().getFirstName()));
                }
            }

        } catch (HibernateException e) {
            LOG.error("Exception occured while getting search {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return pricingGroupsToTo;
    }
}
