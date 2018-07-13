package com.taxi.daoImpl;

import com.taxi.RequestMapper.CabsRequestMapping;
import com.taxi.dao.*;
import com.taxi.domain.Cabs;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.taxi.to.CabsTo;
import com.taxi.to.CabsViewTo;
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
    public Cabs findById(long id) throws Exception {
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
                    return cabs;
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
                            cabs.getCabNo(), cabs.getCabRegistrationNo(),
                            Constants.status().get(cabs.getStatus()),
                            cabs.getPlateNumber()));
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
        List<CabsTo> cabsTo = new ArrayList<>();
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
                    cabsTo.add(new CabsTo(cabs.getCreatedAt(),
                            cabs.getUpdatedAt(), cabs.getDeletedAt(),
                            cabs.getCabId(), cabs.getCabType(),
                            cabs.getCabModel(), cabs.getCabColor(),
                            cabs.getCabNo(), cabs.getCabRegistrationNo(),
                            Constants.status().get(cabs.getStatus()),
                            cabs.getPlateNumber()));
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
                            cabs.getCabNo(), cabs.getCabRegistrationNo(),
                            Constants.status().get(cabs.getStatus()),
                            cabs.getPlateNumber()));
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
                            cabs.getCabNo(), cabs.getCabRegistrationNo(),
                            Constants.status().get(cabs.getStatus()),
                            cabs.getPlateNumber()));
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
            hql = "from Cabs cabs where cabs.cabId = :cabId";
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

    @Override
    public CabsRequestMapping details(long id) throws Exception {

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
                    CabsRequestMapping cabsRequestMapping = new CabsRequestMapping();
                    cabsRequestMapping.setAttributeId(cabs.getCabAttributes().getAttributeId());
                    cabsRequestMapping.setAvgCondition(cabs.getCabAttributes().getAvgCondition());
                    cabsRequestMapping.setCabColor(cabs.getCabColor());
                    cabsRequestMapping.setCabId(cabs.getCabId());
                    cabsRequestMapping.setCabModel(cabs.getCabModel());
                    cabsRequestMapping.setCabNo(cabs.getCabNo());
                    cabsRequestMapping.setCabRegistrationNo(cabs.getCabRegistrationNo());
                    cabsRequestMapping.setCabType(cabs.getCabType());
                    cabsRequestMapping.setDocumentId(cabs.getCabDocuments().getDocumentId());
                    cabsRequestMapping.setEightSeater(cabs.getCabAttributes().getEightSeater());
                    cabsRequestMapping.setExexutive(cabs.getCabAttributes().getExexutive());
                    cabsRequestMapping.setFiveSeater(cabs.getCabAttributes().getFiveSeater());
                    cabsRequestMapping.setFourSeater(cabs.getCabAttributes().getFourSeater());
                    cabsRequestMapping.setGoodCOndition(cabs.getCabAttributes().getGoodCOndition());
                    cabsRequestMapping.setHireExpiry(cabs.getHireExpiry());
                    cabsRequestMapping.setInsurancePolicyNumber(cabs.getInsurancePolicyNumber());
                    cabsRequestMapping.setInsurer(cabs.getInsurer());
                    cabsRequestMapping.setInuranceExpiryDate(cabs.getInuranceExpiryDate());
                    cabsRequestMapping.setInuranceCopy(cabs.getCabDocuments().getInuranceCopy());
                    cabsRequestMapping.setLicencePapers(cabs.getCabDocuments().getLicencePapers());
                    cabsRequestMapping.setMot(cabs.getMot());
                    cabsRequestMapping.setMotExpiry(cabs.getMotExpiry());
                    cabsRequestMapping.setOwnerDriver(cabs.getOwnerDriver());
                    cabsRequestMapping.setPcolicence(cabs.getCabDocuments().getPcolicence());
                    cabsRequestMapping.setPlateNumber(cabs.getPlateNumber());
                    cabsRequestMapping.setPoliceDisclouser(cabs.getCabDocuments().getPoliceDisclouser());
                    cabsRequestMapping.setPricingId(cabs.getPricingGroups().getPricingId());
                    cabsRequestMapping.setProofOfAddress(cabs.getCabDocuments().getProofOfAddress());
                    cabsRequestMapping.setRoadTaxExpiry(cabs.getRoadTaxExpiry());
                    cabsRequestMapping.setSevenSeater(cabs.getCabAttributes().getSevenSeater());
                    cabsRequestMapping.setSixSeater(cabs.getCabAttributes().getSixSeater());
                    cabsRequestMapping.setStatus(cabs.getStatus());
                    cabsRequestMapping.setVehicleStart(cabs.getVehicleStart());
                    cabsRequestMapping.setVendorId(cabs.getVendors().getVendorId());
                    cabsRequestMapping.setWheelChair(cabs.getCabAttributes().getWheelChair());
                    cabsRequestMapping.setYearOfRegistration(cabs.getYearOfRegistration());
                    return cabsRequestMapping;
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting details {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public CabsViewTo view(long id) throws Exception {

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
                    CabsViewTo cabsViewTo = new CabsViewTo();
                    cabsViewTo.setAttributeId(cabs.getCabAttributes().getAttributeId());
                    cabsViewTo.setAvgCondition(cabs.getCabAttributes().getAvgCondition());
                    cabsViewTo.setCabColor(cabs.getCabColor());
                    cabsViewTo.setCabId(cabs.getCabId());
                    cabsViewTo.setCabModel(cabs.getCabModel());
                    cabsViewTo.setCabNo(cabs.getCabNo());
                    cabsViewTo.setCabRegistrationNo(cabs.getCabRegistrationNo());
                    cabsViewTo.setCabType(cabs.getCabType());
                    cabsViewTo.setDocumentId(cabs.getCabDocuments().getDocumentId());
                    cabsViewTo.setEightSeater(cabs.getCabAttributes().getEightSeater());
                    cabsViewTo.setExexutive(cabs.getCabAttributes().getExexutive());
                    cabsViewTo.setFiveSeater(cabs.getCabAttributes().getFiveSeater());
                    cabsViewTo.setFourSeater(cabs.getCabAttributes().getFourSeater());
                    cabsViewTo.setGoodCOndition(cabs.getCabAttributes().getGoodCOndition());
                    cabsViewTo.setHireExpiry(cabs.getHireExpiry());
                    cabsViewTo.setInsurancePolicyNumber(cabs.getInsurancePolicyNumber());
                    cabsViewTo.setInsurer(cabs.getInsurer());
                    cabsViewTo.setInuranceExpiryDate(cabs.getInuranceExpiryDate());
                    cabsViewTo.setInuranceCopy(cabs.getCabDocuments().getInuranceCopy());
                    cabsViewTo.setLicencePapers(cabs.getCabDocuments().getLicencePapers());
                    cabsViewTo.setMot(cabs.getMot());
                    cabsViewTo.setMotExpiry(cabs.getMotExpiry());
                    cabsViewTo.setOwnerDriver(cabs.getOwnerDriver());
                    cabsViewTo.setPcolicence(cabs.getCabDocuments().getPcolicence());
                    cabsViewTo.setPlateNumber(cabs.getPlateNumber());
                    cabsViewTo.setPoliceDisclouser(cabs.getCabDocuments().getPoliceDisclouser());
                    cabsViewTo.setPricingId(cabs.getPricingGroups().getPricingId());
                    cabsViewTo.setProofOfAddress(cabs.getCabDocuments().getProofOfAddress());
                    cabsViewTo.setRoadTaxExpiry(cabs.getRoadTaxExpiry());
                    cabsViewTo.setSevenSeater(cabs.getCabAttributes().getSevenSeater());
                    cabsViewTo.setSixSeater(cabs.getCabAttributes().getSixSeater());
                    cabsViewTo.setStatus(cabs.getStatus());
                    cabsViewTo.setVehicleStart(cabs.getVehicleStart());
                    cabsViewTo.setVendorId(cabs.getVendors().getVendorId());
                    cabsViewTo.setWheelChair(cabs.getCabAttributes().getWheelChair());
                    cabsViewTo.setYearOfRegistration(cabs.getYearOfRegistration());
                    cabsViewTo.setCreatedAt(cabs.getCreatedAt());
                    cabsViewTo.setUpdatedAt(cabs.getUpdatedAt());
                    cabsViewTo.setDeletedAt(cabs.getDeletedAt());
                    return cabsViewTo;
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting details {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
}
