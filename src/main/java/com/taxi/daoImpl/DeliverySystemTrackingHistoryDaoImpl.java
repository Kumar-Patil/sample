package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.DeliverySystemTrackingDetails;
import com.taxi.to.DeliverySystemTrackingHistoryTransfer;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

public class DeliverySystemTrackingHistoryDaoImpl implements DeliverySystemTrackingHistoryDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(DeliverySystemTrackingHistoryDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean add(DeliverySystemTrackingDetails deliverySystemTrackingDetails) throws Exception {
        boolean isAdded = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(deliverySystemTrackingDetails);
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

    @SuppressWarnings("unchecked")
    @Override
    public List<DeliverySystemTrackingHistoryTransfer> list(Long deliveryId) throws Exception {
        List<DeliverySystemTrackingHistoryTransfer> deliverySystemList = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            deliverySystemList = session.createSQLQuery("SELECT id as id ,"
                    + "created_at as createdAt, updated_at as updatedAt,"
                    + "delivery_message as deliveryMessage,delivery_status "
                    + "as deliveryStatus FROM "
                    + "taxi.delivery_tracking_details "
                    + "where delivery_system_id=+" + deliveryId + "+ order by id asc")
                    .addScalar("id", StandardBasicTypes.LONG)
                    .addScalar("createdAt")
                    .addScalar("updatedAt")
                    .addScalar("deliveryMessage")
                    .addScalar("deliveryStatus")
                    .setResultTransformer(Transformers.aliasToBean(DeliverySystemTrackingHistoryTransfer.class))
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

}
