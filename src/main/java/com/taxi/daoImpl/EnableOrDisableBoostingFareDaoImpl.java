package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.EnableOrDisableBoostingFare;
import com.taxi.to.EnableDisableBoostPricing;
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

public class EnableOrDisableBoostingFareDaoImpl implements EnableOrDisableBoostingFareDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(EnableOrDisableBoostingFareDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean update(EnableOrDisableBoostingFare boostingFare) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(boostingFare);
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while updating {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public EnableDisableBoostPricing list() throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<EnableOrDisableBoostingFare> boostingFaresList = null;
            String hql = null;
            hql = "from EnableOrDisableBoostingFare ";
            Query query = (Query) session.createQuery(hql);
            boostingFaresList = query.list();
            tx.commit();
            for (EnableOrDisableBoostingFare enableOrDisableBoostingFare : boostingFaresList) {
                return new EnableDisableBoostPricing(enableOrDisableBoostingFare.getId(), enableOrDisableBoostingFare.getBoostEnable(), enableOrDisableBoostingFare.getSurgeEnable());
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting boostingFaresList {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

}
