package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.OrderCategory;
import com.taxi.domain.OrderType;
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

public class OrderTypeDaoImpl implements OrderTypeDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(OrderTypeDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean add(OrderType orderType) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(orderType);
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
    public OrderType findById(int id) throws Exception {
        OrderType orderType = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<OrderType> orderTypeList = null;
            String hql = null;
            hql = "from OrderCategory orderCategory where orderCategory.id =:Id";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("id", id);
            orderTypeList = query.list();
            tx.commit();
            if (orderTypeList.size() > 0) {
                for (OrderType orderType1 : orderTypeList) {
                    return orderType1;
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return orderType;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderType> list() throws Exception {
        List<OrderType> orderTypes = new ArrayList();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = null;
            hql = "from OrderType orderType ORDER BY orderType.name ASC";
            Query query = (Query) session.createQuery(hql);
            orderTypes = query.list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return orderTypes;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean delete(long id)
            throws Exception {
        try {
            session = sessionFactory.openSession();
            Object o = session.load(OrderType.class, id);
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
    public OrderType ViewById(long id) throws Exception {
        OrderType orderType = null;
        try {
            session = sessionFactory.openSession();
            orderType = (OrderType) session.load(OrderCategory.class, id);
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
        return orderType;
    }
}
