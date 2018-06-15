package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.OrderCategory;
import com.taxi.domain.States;
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

public class OrderCategoryDaoImpl implements OrderCategoryDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(OrderCategoryDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean add(OrderCategory orderCategory) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(orderCategory);
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
    public OrderCategory findById(int id) throws Exception {
        OrderCategory orderCategory = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<OrderCategory> orderCategoryList = null;
            String hql = null;
            hql = "from OrderCategory orderCategory where orderCategory.id =:Id";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("id", id);
            orderCategoryList = query.list();
            tx.commit();
            if (orderCategoryList.size() > 0) {
                for (OrderCategory orderCategory1 : orderCategoryList) {
                    return orderCategory1;
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return orderCategory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderCategory> list() throws Exception {
        List<OrderCategory> orderCategoryList = new ArrayList();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = null;
            hql = "from OrderCategory orderCategory ORDER BY orderCategory.name ASC";
            Query query = (Query) session.createQuery(hql);
            orderCategoryList = query.list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return orderCategoryList;
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
    public OrderCategory ViewById(long id) throws Exception {
        OrderCategory orderCategory = null;
        try {
            session = sessionFactory.openSession();
            orderCategory = (OrderCategory) session.load(OrderCategory.class, id);
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
        return orderCategory;
    }
}
