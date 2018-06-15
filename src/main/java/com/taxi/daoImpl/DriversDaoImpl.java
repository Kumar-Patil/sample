package com.taxi.daoImpl;

import com.taxi.RequestMapper.DriverRequestMapper;
import com.taxi.dao.*;
import com.taxi.domain.Drivers;
import com.taxi.to.DriversTo;
import com.taxi.to.ViewDriver;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class DriversDaoImpl implements DriversDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(DriversDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean add(Drivers drivers) throws Exception {
        boolean isAdded = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(drivers);
            tx.commit();
            return isAdded = true;
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
    public DriverRequestMapper findById(long id) throws Exception {
        DriverRequestMapper driverRequestMapper = new DriverRequestMapper();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Drivers> driverList = null;
            String hql = null;
            hql = "from Drivers drivers where drivers.driverId =:driverId ";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("driverId", id);
            driverList = query.list();
            tx.commit();
            if (driverList.size() > 0) {
                for (Drivers drivers : driverList) {
                    driverRequestMapper.setDriverId(drivers.getDriverId());
                    driverRequestMapper.setAddress(drivers.getAddress());
                    driverRequestMapper.setAgreement(drivers.getDriverDocuments().getAgreement());
                    driverRequestMapper.setAliasName(drivers.getAliasName());
                    driverRequestMapper.setCabId(drivers.getCabs().getCabId());
                    driverRequestMapper.setCityId(drivers.getLocations().getCities().getCityId());
                    driverRequestMapper.setCountryId(drivers.getLocations().getCountries().getCountriId());

                    driverRequestMapper.setDriverLicenceExpiry(drivers.getDriverLicenceExpiry());
                    driverRequestMapper.setDriverLicenceNumber(drivers.getDriverLicenceNumber());
                    driverRequestMapper.setEmail(drivers.getEmail());
                    driverRequestMapper.setFirstName(drivers.getFirstName());
                    driverRequestMapper.setLastName(drivers.getLastName());
                    driverRequestMapper.setMobileNo(drivers.getMobileNo());
                    driverRequestMapper.setOtherPhone(drivers.getOtherPhone());
                    driverRequestMapper.setPassword(drivers.getPassword());
                    driverRequestMapper.setZip(drivers.getLocations().getZip());
                    driverRequestMapper.setPhoto(drivers.getPhoto());
                    driverRequestMapper.setSex(drivers.getSex());
                    driverRequestMapper.setStartDate(drivers.getStartDate());
                    driverRequestMapper.setStateId(drivers.getLocations().getStates().getStateId());
                    driverRequestMapper.setStatus(drivers.getStatus());
                    driverRequestMapper.setStreet(drivers.getLocations().getStreet());

                    driverRequestMapper.setDriverAttribteId(drivers.getDriverAttributes().getDriverAttribteId());
                    driverRequestMapper.setCrb(drivers.getDriverAttributes().getCrb());
                    driverRequestMapper.setNHS(drivers.getDriverAttributes().getNHS());
                    driverRequestMapper.setFemale(drivers.getDriverAttributes().getFemale());
                    driverRequestMapper.setLuggage(drivers.getDriverAttributes().getLuggage());
                    driverRequestMapper.setDelivery(drivers.getDriverAttributes().getDelivery());
                    driverRequestMapper.setPets(drivers.getDriverAttributes().getPets());
                    driverRequestMapper.setTopman(drivers.getDriverAttributes().getTopman());
                    driverRequestMapper.setUniformed(drivers.getDriverAttributes().getUniformed());

                    driverRequestMapper.setDriverDocumentId(drivers.getDriverDocuments().getDriverDocumentId());
                    driverRequestMapper.setPoliceDisclose(drivers.getDriverDocuments().getPoliceDisclose());
                    driverRequestMapper.setProofOfAddress(drivers.getDriverDocuments().getProofOfAddress());
                    driverRequestMapper.setAgreement(drivers.getDriverDocuments().getAgreement());
                    driverRequestMapper.setLicencePaper(drivers.getDriverDocuments().getLicencePaper());
                    driverRequestMapper.setLicencePhoto(drivers.getDriverDocuments().getLicencePhoto());
                    driverRequestMapper.setInsurance(drivers.getDriverDocuments().getInsurance());
                    driverRequestMapper.setPcoLicence(drivers.getDriverDocuments().getPcoLicence());

                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return driverRequestMapper;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DriversTo> list() throws Exception {
        List<DriversTo> drivers = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Drivers> driverList = null;
            String hql = null;
            hql = "from Drivers drivers where drivers.status =:status";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("status", 1);
            driverList = query.list();
            for (Drivers drivers1 : driverList) {
                drivers.add(new DriversTo(drivers1.getFirstName(), drivers1.getLastName(),
                        drivers1.getSex(), drivers1.getStatus(), drivers1.getMobileNo(), drivers1.getEmail(), drivers1.getDriverId()));
            }
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return drivers;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean delete(long id)
            throws Exception {
        try {
            session = sessionFactory.openSession();
            Object o = session.load(Drivers.class, id);
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
    public ViewDriver ViewById(long id) throws Exception {
        ViewDriver viewDriver = new ViewDriver();
        Map<String, Object> driverViewMap = new HashMap<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Drivers> driverList = null;
            String hql = null;
            hql = "from Drivers drivers where drivers.driverId =:driverId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("driverId", id);
            driverList = query.list();
            for (Drivers drivers1 : driverList) {
                viewDriver.setAddress(drivers1.getAddress());
                viewDriver.setAliasName(drivers1.getAliasName());
                viewDriver.setCityName(drivers1.getLocations().getCities().getCitieName());
                viewDriver.setCountryName(drivers1.getLocations().getCountries().getName());
                viewDriver.setCrb(drivers1.getDriverAttributes().getCrb());
                viewDriver.setCreatedAt(drivers1.getCreatedAt());
                viewDriver.setDriverLicenceExpiry(drivers1.getDriverLicenceExpiry());
                viewDriver.setDriverLicenceNumber(drivers1.getDriverLicenceNumber());
                viewDriver.setEmail(drivers1.getEmail());
                viewDriver.setFirstName(drivers1.getFirstName());
                viewDriver.setLastName(drivers1.getLastName());
                viewDriver.setMobileNo(drivers1.getMobileNo());
                viewDriver.setOtherPhone(drivers1.getOtherPhone());
                viewDriver.setPassword(drivers1.getPassword());
                viewDriver.setUpdatedAt(drivers1.getUpdatedAt());
                viewDriver.setZip(drivers1.getLocations().getZip());
                viewDriver.setPhoto(drivers1.getPhoto());
                viewDriver.setSex(drivers1.getSex());
                viewDriver.setStartDate(drivers1.getStartDate());
                viewDriver.setStateName(drivers1.getLocations().getStates().getState());
                viewDriver.setStatus(drivers1.getStatus());
                viewDriver.setStreet(drivers1.getLocations().getStreet());

                viewDriver.setNHS(drivers1.getDriverAttributes().getNHS());
                viewDriver.setFemale(drivers1.getDriverAttributes().getFemale());
                viewDriver.setLuggage(drivers1.getDriverAttributes().getLuggage());
                viewDriver.setDelivery(drivers1.getDriverAttributes().getDelivery());
                viewDriver.setPets(drivers1.getDriverAttributes().getPets());
                viewDriver.setTopman(drivers1.getDriverAttributes().getTopman());
                viewDriver.setUniformed(drivers1.getDriverAttributes().getUniformed());

                viewDriver.setPoliceDisclose(drivers1.getDriverDocuments().getPoliceDisclose());
                viewDriver.setProofOfAddress(drivers1.getDriverDocuments().getProofOfAddress());
                viewDriver.setAgreement(drivers1.getDriverDocuments().getAgreement());
                viewDriver.setLicencePaper(drivers1.getDriverDocuments().getLicencePaper());
                viewDriver.setLicencePhoto(drivers1.getDriverDocuments().getLicencePhoto());
                viewDriver.setInsurance(drivers1.getDriverDocuments().getInsurance());
                viewDriver.setPcoLicence(drivers1.getDriverDocuments().getPcoLicence());

            }
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return viewDriver;
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
            String hql = "UPDATE Drivers drivers set drivers.status =:status,drivers.deletedAt =:deletedAt "
                    + "WHERE drivers.driverId =:driverId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("driverId", driverId);
            query.setParameter("status", 0);
            query.setParameter("deletedAt", currentTimestamp);
            query.executeUpdate();
            tx.commit();
            isStatusUpdated = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while updating driverId {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return isStatusUpdated;

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DriversTo> search(String searchVal) throws Exception {
        List<DriversTo> drivers = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Drivers> driverList = null;
            String hql = null;
            hql = "from Drivers drivers where drivers.status = 1 and drivers.email like "
                    + "'" + searchVal + "%' or drivers.firstName like '" + searchVal + "%' "
                    + "or drivers.mobileNo like '" + searchVal + "%' "
                    + "or drivers.lastName like '" + searchVal + "%' or drivers.sex like '" + searchVal + "%'";
            Query query = (Query) session.createQuery(hql);
            driverList = query.list();
            for (Drivers drivers1 : driverList) {
                drivers.add(new DriversTo(drivers1.getFirstName(), drivers1.getLastName(),
                        drivers1.getSex(), drivers1.getStatus(), drivers1.getMobileNo(), drivers1.getEmail(), drivers1.getDriverId()));
            }
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return drivers;
    }

    @Override
    public Drivers locationId(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Drivers> driverList = null;
            String hql = null;
            hql = "from Drivers drivers where drivers.driverId =:driverId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("driverId", id);
            driverList = query.list();
            tx.commit();
            if (driverList.size() > 0) {
                for (Drivers drivers : driverList) {
                    return drivers;
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
    public List<DriversTo> listOfCabsBasedOnVendorType(long vendorId) throws Exception {
        List<DriversTo> drivers = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Drivers> driverList = null;
            String hql = null;
            hql = "from Drivers drivers where drivers.vendors.vendorId =:vendorId and drivers.status =:status";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("status", 1);
            query.setParameter("vendorId", vendorId);
            driverList = query.list();
            for (Drivers drivers1 : driverList) {
                drivers.add(new DriversTo(drivers1.getFirstName(), drivers1.getLastName(),
                        drivers1.getSex(), drivers1.getStatus(), drivers1.getMobileNo(), drivers1.getEmail(), drivers1.getDriverId()));
            }
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return drivers;
    }
}
