package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.DeliverySystem;
import com.taxi.to.DeliverySystemTransfer;
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
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class DeliverySystemDaoImpl implements DeliverySystemDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(DeliverySystemDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean add(DeliverySystem deliverySystem) throws Exception {
        boolean isAdded = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(deliverySystem);
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
    public DeliverySystem findById(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<DeliverySystem> deliverySystemList = null;
            String hql = null;
            hql = "from DeliverySystem deliverySystem where deliverySystem.deliveryId = :deliveryId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("deliveryId", id);
            deliverySystemList = query.list();
            tx.commit();
            if (deliverySystemList.size() > 0) {
                for (DeliverySystem deliverySystem : deliverySystemList) {
                    DeliverySystem ds = new DeliverySystem();

                    ds.setBookingAt(deliverySystem.getBookingAt());
                    ds.setContactPersonEmail(deliverySystem.getContactPersonEmail());
                    ds.setContactPersonMobileno(deliverySystem.getContactPersonMobileno());
                    ds.setContactPersonName(deliverySystem.getContactPersonName());

                    ds.setCreatedAt(deliverySystem.getCreatedAt());
                    ds.setDeliveryAt(deliverySystem.getDeliveryAt());
                    ds.setDeliveryCurrentStatus(deliverySystem.getDeliveryCurrentStatus());
                    ds.setNoOfUnits(deliverySystem.getNoOfUnits());

                    ds.setOrderCategory(deliverySystem.getOrderCategory());
                    ds.setOrderType(deliverySystem.getOrderType());
                    ds.setPickUpAddress(deliverySystem.getPickUpAddress());
                    ds.setPickUpAt(deliverySystem.getPickUpAt());

                    ds.setPickUpPinCode(deliverySystem.getPickUpPinCode());
                    ds.setReciptentAddress(deliverySystem.getReciptentAddress());
                    ds.setReciptentName(deliverySystem.getReciptentName());
                    ds.setReciptentEmail(deliverySystem.getReciptentEmail());

                    ds.setReciptentMobileNo(deliverySystem.getReciptentMobileNo());
                    ds.setReciptentPinCode(deliverySystem.getReciptentPinCode());
                    ds.setStatus(deliverySystem.getStatus());
                    ds.setType(deliverySystem.getType());
                    ds.setUpdatedAt(deliverySystem.getUpdatedAt());
                    ds.setWeight(deliverySystem.getWeight());
                    return ds;
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
    public List<DeliverySystemTransfer> list() throws Exception {
        List<DeliverySystemTransfer> deliverySystemList = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            deliverySystemList = session.createSQLQuery(
                    "SELECT id as deliveryId,type as type,"
                    + "delivery_current_status as deliveryCurrentStatus"
                    + ",order_type as orderType,"
                    + "weight as weight,"
                    + "no_of_units as noOfUnits,"
                    + "contact_person_name as contactPersonName,"
                    + "reciptent_name as reciptentName,"
                    + "booking_at as bookingAt FROM taxi.delivery_system")
                    .addScalar("deliveryId", StandardBasicTypes.LONG)
                    .addScalar("type")
                    .addScalar("deliveryCurrentStatus")
                    .addScalar("orderType")
                    .addScalar("weight", StandardBasicTypes.LONG)
                    .addScalar("noOfUnits")
                    .addScalar("contactPersonName")
                    .addScalar("reciptentName")
                    .addScalar("bookingAt")
                    .setResultTransformer(Transformers.aliasToBean(DeliverySystemTransfer.class))
                    .list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return deliverySystemList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean updateStatus(long deliveryId) throws Exception {
        boolean isStatusUpdated = false;
        try {
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = "UPDATE DeliverySystem ds set ds.status =:status,ds.deletedAt =:deletedAt "
                    + "WHERE ds.deliveryId =:deliveryId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("deliveryId", deliveryId);
            query.setParameter("status", 0);
            query.setParameter("deletedAt", currentTimestamp);
            query.executeUpdate();
            tx.commit();
            isStatusUpdated = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while updating ds {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return isStatusUpdated;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean updateDeliveryStatus(long deliveryId, String deliveryStatus) throws Exception {
        boolean isStatusUpdated = false;
        try {
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = "UPDATE DeliverySystem ds set ds.deliveryCurrentStatus =:deliveryCurrentStatus,ds.updatedAt =:updatedAt "
                    + "WHERE ds.deliveryId =:deliveryId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("deliveryId", deliveryId);
            query.setParameter("deliveryCurrentStatus", deliveryStatus);
            query.setParameter("updatedAt", currentTimestamp);
            query.executeUpdate();
            tx.commit();
            isStatusUpdated = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while updating ds {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return isStatusUpdated;

    }

}
