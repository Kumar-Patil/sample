package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.Cabs;
import com.taxi.domain.Cities;
import com.taxi.to.City;
import java.util.ArrayList;
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

public class CitiesDaoImpl implements CitiesDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(CitiesDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean add(Cities cities) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(cities);
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
    public Cities findById(int id) throws Exception {
        Cities cities = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Cities> citiesList = null;
            String hql = null;
            hql = "from Cities cities where cities.cityId =:Id";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("Id", id);
            citiesList = query.list();
            tx.commit();
            if (citiesList.size() > 0) {
                for (Cities cities1 : citiesList) {
                    return cities1;
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return cities;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<City> list() throws Exception {
        List<City> list = new ArrayList();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<Cities> citiesList = null;
            String hql = null;
            hql = "from Cities cities ORDER BY cities.citieName ASC";
            Query query = (Query) session.createQuery(hql);
            citiesList = query.list();
            for (Cities cities : citiesList) {
                list.add(new City(cities.getCityId(), cities.getCitieName(), cities.getStates().getStateId()));
            }
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
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
    public Cities ViewById(long id) throws Exception {
        Cities cities = null;
        try {
            session = sessionFactory.openSession();
            cities = (Cities) session.load(Cities.class, id);
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
        return cities;
    }
}
