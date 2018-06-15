package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.Countries;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.taxi.domain.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class CountriesDaoImpl implements CountriesDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(CountriesDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean add(Countries countries) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(countries);
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while adding {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public Countries findById(int id) throws Exception {
        Countries countries = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Countries> countryList = null;
            String hql = null;
            hql = "from Countries countries where countries.countriId =:Id";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("Id", id);
            countryList = query.list();
            tx.commit();
            if (countryList.size() > 0) {
                for (Countries countries1 : countryList) {
                    return countries1;
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return countries;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Countries> list() throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Countries> countryList = null;
            String hql = null;
            hql = "from Countries countries  ORDER BY countries.name ASC";
            Query query = (Query) session.createQuery(hql);
            countryList = query.list();
            tx.commit();
            return countryList;
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
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean delete(long id)
            throws Exception {
        try {
            session = sessionFactory.openSession();
            Object o = session.load(Countries.class, id);
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
    public Countries ViewById(long id) throws Exception {
        Countries countries = null;
        try {
            session = sessionFactory.openSession();
            countries = (Countries) session.load(User.class, id);
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
        return countries;
    }
}
