package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.BankAccountDetails;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class BankAccountDetailsDaoImpl implements BankAccountDetailsDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(BankAccountDetailsDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public Long add(BankAccountDetails bankAccountDetails) throws Exception {
        Long locationId = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            locationId = (Long) session.save(bankAccountDetails);
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while adding {}" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return locationId;
    }

    @Override
    public BankAccountDetails findById(long id) throws Exception {
        BankAccountDetails bankAccountDetails = null;
        try {
            session = sessionFactory.openSession();
            bankAccountDetails = (BankAccountDetails) session.load(BankAccountDetails.class,
                    new Long(id));
            tx = session.getTransaction();
            session.beginTransaction();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return bankAccountDetails;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BankAccountDetails> list() throws Exception {
        List<BankAccountDetails> bankAccountDetailses = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            bankAccountDetailses = session.createCriteria(BankAccountDetails.class)
                    .list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return bankAccountDetailses;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean delete(long id)
            throws Exception {
        try {
            session = sessionFactory.openSession();
            Object o = session.load(BankAccountDetails.class, id);
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
    public BankAccountDetails ViewById(long id) throws Exception {
        BankAccountDetails bankAccountDetails = null;
        try {
            session = sessionFactory.openSession();
            bankAccountDetails = (BankAccountDetails) session.load(BankAccountDetails.class, id);
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
        return bankAccountDetails;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean update(BankAccountDetails bankAccountDetails) throws Exception {
        boolean isUpdated = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(bankAccountDetails);
            tx.commit();
            isUpdated = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while adding {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isUpdated;
    }
}
