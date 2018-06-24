package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.Cabs;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.taxi.to.CabsTo;
import com.taxi.util.Constants;
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

public class CabsDaoImpl implements CabsDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(CabsDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean add(Cabs cabs) throws Exception {
        boolean isAdded = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(cabs);
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
    public CabsTo findById(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Cabs> cabsList = null;
            String hql = null;
            hql = "from Cabs cabs where cabs.cabId = :cabId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("cabId", id);
            cabsList = query.list();
            tx.commit();
            if (cabsList.size() > 0) {
                for (Cabs cabs : cabsList) {
                    return new CabsTo(cabs.getCreatedAt(),
                            cabs.getUpdatedAt(), cabs.getDeletedAt(),
                            cabs.getCabId(), cabs.getCabType(),
                            cabs.getCabModel(), cabs.getCabColor(),
                            cabs.getCabNo(), cabs.getCabRegistrationNo(), Constants.status().get(cabs.getStatus()),
                            cabs.getVendors().getVendorId(), cabs.getPricingGroups().getPricingId());
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
    public List<CabsTo> list() throws Exception {
        List<CabsTo> cabsTo = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Cabs> cabsList = null;
            String hql = null;
            hql = "from Cabs cabs where cabs.status =:status";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("status", 1);
            cabsList = query.list();
            tx.commit();
            if (cabsList.size() > 0) {
                for (Cabs cabs : cabsList) {
                    cabsTo.add(new CabsTo(cabs.getCreatedAt(),
                            cabs.getUpdatedAt(), cabs.getDeletedAt(),
                            cabs.getCabId(), cabs.getCabType(),
                            cabs.getCabModel(), cabs.getCabColor(),
                            cabs.getCabNo(), cabs.getCabRegistrationNo(), Constants.status().get(cabs.getStatus()),
                            cabs.getVendors().getVendorId(), cabs.getPricingGroups().getPricingId()));
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return cabsTo;
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
    public CabsTo ViewById(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Cabs> cabsList = null;
            String hql = null;
            hql = "from Cabs cabs where cabs.cabId =:cabId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("cabId", id);
            cabsList = query.list();
            tx.commit();
            if (cabsList.size() > 0) {
                for (Cabs cabs : cabsList) {
                    return new CabsTo(cabs.getCreatedAt(),
                            cabs.getUpdatedAt(), cabs.getDeletedAt(),
                            cabs.getCabId(), cabs.getCabType(),
                            cabs.getCabModel(), cabs.getCabColor(),
                            cabs.getCabNo(), cabs.getCabRegistrationNo(), Constants.status().get(cabs.getStatus()),
                            cabs.getVendors().getVendorId(), cabs.getPricingGroups().getPricingId());
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
            String hql = "UPDATE Cabs cabs set cabs.status =:status,cabs.deletedAt =:deletedAt "
                    + "WHERE cabs.cabId =:cabId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("cabId", cabId);
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public List<CabsTo> search(String searchVal) throws Exception {
        List<CabsTo> cabsTo = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = null;
            List<Cabs> cabsList = null;
            hql = "from Cabs cabs where cabs.cabType like "
                    + "'" + searchVal + "%' "
                    + "or cabs.cabModel like '" + searchVal + "%' "
                    + "or cabs.cabRegistrationNo like '" + searchVal + "%' "
                    + "or cabs.cabColor like '" + searchVal + "%' or cabs.cabNo like '" + searchVal + "%'";
            Query query = (Query) session.createQuery(hql);
            cabsList = query.list();
            if (cabsList.size() > 0) {
                for (Cabs cabs : cabsList) {
                    cabsTo.add(new CabsTo(cabs.getCreatedAt(),
                            cabs.getUpdatedAt(), cabs.getDeletedAt(),
                            cabs.getCabId(), cabs.getCabType(),
                            cabs.getCabModel(), cabs.getCabColor(),
                            cabs.getCabNo(), cabs.getCabRegistrationNo(), Constants.status().get(cabs.getStatus()),
                            cabs.getVendors().getVendorId(), cabs.getPricingGroups().getPricingId()));
                }
            }

        } catch (HibernateException e) {
            LOG.error("Exception occured while getting search {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return cabsTo;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CabsTo> listOfCabsBasedOnVendorType(long vendorId) throws Exception {
        List<CabsTo> cabsTo = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Cabs> cabsList = null;
            String hql = null;
            hql = "from Cabs cabs where cabs.vendors.vendorId =:vendorId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("vendorId", vendorId);
            cabsList = query.list();
            tx.commit();
            if (cabsList.size() > 0) {
                for (Cabs cabs : cabsList) {
                    cabsTo.add(new CabsTo(cabs.getCreatedAt(),
                            cabs.getUpdatedAt(), cabs.getDeletedAt(),
                            cabs.getCabId(), cabs.getCabType(),
                            cabs.getCabModel(), cabs.getCabColor(),
                            cabs.getCabNo(), cabs.getCabRegistrationNo(), Constants.status().get(cabs.getStatus()),
                            cabs.getVendors().getVendorId(), cabs.getPricingGroups().getPricingId()));
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return cabsTo;
    }

    @Override
    public long vendorId(long id) throws Exception {
        Long vendorId = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Cabs> cabsList = null;
            String hql = null;
            hql = "SELECT cabs.vendors.vendorId from Cabs cabs where cabs.cabId = :cabId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("cabId", id);
            cabsList = query.list();
            tx.commit();
            if (cabsList.size() > 0) {
                for (Cabs cabs : cabsList) {
                    return cabs.getVendors().getVendorId();
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return vendorId;
    }
}
