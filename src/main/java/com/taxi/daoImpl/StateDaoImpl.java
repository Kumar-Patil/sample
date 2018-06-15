package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.States;
import com.taxi.to.State;
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

public class StateDaoImpl implements StateDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(StateDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean add(States state) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(state);
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
    public States findById(int id) throws Exception {
        States state = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<States> stateList = null;
            String hql = null;
            hql = "from States states where states.stateId =:Id";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("Id", 1);
            stateList = query.list();
            tx.commit();
            if (stateList.size() > 0) {
                for (States state1 : stateList) {
                    return state1;
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return state;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<State> list() throws Exception {
        List<State> list = new ArrayList();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<States> stateList = null;
            String hql = null;
            hql = "from States states ORDER BY states.state ASC";
            Query query = (Query) session.createQuery(hql);
            stateList = query.list();
            for (States states : stateList) {
                list.add(new State(states.getStateId(), states.getState(), states.getStateCode(), states.getCountries().getCountriId()));
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
            Object o = session.load(States.class, id);
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
    public States ViewById(long id) throws Exception {
        States state = null;
        try {
            session = sessionFactory.openSession();
            state = (States) session.load(States.class, id);
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
        return state;
    }
}
