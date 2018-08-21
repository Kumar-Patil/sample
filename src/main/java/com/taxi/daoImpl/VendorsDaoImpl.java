package com.taxi.daoImpl;

import com.taxi.RequestMapper.VendorRequestMapper;
import com.taxi.dao.*;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.taxi.domain.Vendors;
import com.taxi.to.VendorsTo;
import com.taxi.to.ViewVendorTo;
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

public class VendorsDaoImpl implements VendorsDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(VendorsDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean add(Vendors vendors) throws Exception {
        boolean isAdded = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(vendors);
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
    public VendorRequestMapper findById(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Vendors> vendorsList = null;
            String hql = null;
            hql = "from Vendors vendors where vendors.vendorId =:vendorId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("vendorId", id);
            vendorsList = query.list();
            tx.commit();
            if (vendorsList.size() > 0) {
                for (Vendors vendors1 : vendorsList) {
                    return new VendorRequestMapper(vendors1.getVendorId(),
                            vendors1.getStatus(), vendors1.getFirstName(),
                            vendors1.getLastName(), vendors1.getPhoto(),
                            vendors1.getLocations().getAddress(), vendors1.getVendorRegistrationNo(),
                            vendors1.getLocations().getStreet(), vendors1.getLocations().getZip(),
                            vendors1.getLocations().getCities().getCityId(),
                            vendors1.getLocations().getStates().getStateId(),
                            vendors1.getLocations().getCountries().getCountriId(),
                            vendors1.getLocations().getLocationId(), vendors1.getEmail(), vendors1.getMobileNo());
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
    public List<VendorsTo> list() throws Exception {
        List<VendorsTo> vendorsesTo = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Vendors> vendorsList = null;
            String hql = null;
            hql = "from Vendors vendors where vendors.status =:status";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("status", 1);
            vendorsList = query.list();
            tx.commit();
            if (vendorsList.size() > 0) {
                for (Vendors vendors1 : vendorsList) {
                    vendorsesTo.add(new VendorsTo(vendors1.getFirstName(),
                            vendors1.getLastName(), vendors1.getEmail(),
                            vendors1.getMobileNo(), vendors1.getVendorId(), Constants.status().get(vendors1.getStatus()), vendors1.getVendorRegistrationNo()));
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting list of vendors {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return vendorsesTo;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean delete(long id)
            throws Exception {
        try {
            session = sessionFactory.openSession();
            Object o = session.load(Vendors.class, id);
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
    public ViewVendorTo ViewById(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Vendors> vendorsList = null;
            String hql = null;
            hql = "from Vendors vendors where vendors.vendorId =:vendorId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("vendorId", id);
            vendorsList = query.list();
            tx.commit();

            if (vendorsList.size() > 0) {
                for (Vendors vendors1 : vendorsList) {

                    return new ViewVendorTo(vendors1.getVendorId(),
                            Constants.status().get(vendors1.getStatus()), vendors1.getFirstName(),
                            vendors1.getLastName(), vendors1.getPhoto(),
                            vendors1.getCreatedAt(), vendors1.getUpdatedAt(),
                            vendors1.getDeletedAt(), vendors1.getMobileNo(),
                            vendors1.getEmail(), vendors1.getLocations().getLocationId(),
                            vendors1.getLocations().getAddress(),
                            vendors1.getLocations().getStreet(), vendors1.getLocations().getZip(),
                            vendors1.getLocations().getLat(), vendors1.getLocations().getLng(),
                            vendors1.getLocations().getCountries().getName(),
                            vendors1.getLocations().getStates().getState(),
                            vendors1.getLocations().getCities().getCitieName());
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
    public boolean updateStatus(long vendorId) throws Exception {
        boolean isStatusUpdated = false;
        try {
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = "UPDATE Vendors vendor set vendor.status =:status,vendor.deletedAt =:deletedAt "
                    + "WHERE vendor.vendorId =:vendorId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("vendorId", vendorId);
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
    public Vendors details(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Vendors> vendorsList = null;
            String hql = null;
            hql = "from Vendors vendors where vendors.vendorId =:vendorId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("vendorId", id);
            vendorsList = query.list();
            tx.commit();
            if (vendorsList.size() > 0) {
                for (Vendors vendors1 : vendorsList) {
                    return vendors1;
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
    public List<VendorsTo> search(String searchVal) throws Exception {
        List<Vendors> vendorsList = null;
        List<VendorsTo> vendorsesTo = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = null;
            hql = "from Vendors vendors where vendors.email like "
                    + "'" + searchVal + "%' "
                    + "or vendors.mobileNo like '" + searchVal + "%' "
                    + "or vendors.firstName like '" + searchVal + "%' or vendors.lastName like '" + searchVal + "%'";
            Query query = (Query) session.createQuery(hql);
            vendorsList = query.list();
            if (vendorsList.size() > 0) {
                for (Vendors vendors1 : vendorsList) {
                    vendorsesTo.add(new VendorsTo(vendors1.getFirstName(),
                            vendors1.getLastName(), vendors1.getEmail(),
                            vendors1.getMobileNo(), vendors1.getVendorId(), Constants.status().get(vendors1.getStatus()), vendors1.getVendorRegistrationNo()));
                }
            }

        } catch (HibernateException e) {
            LOG.error("Exception occured while getting search {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return vendorsesTo;
    }
    
}
