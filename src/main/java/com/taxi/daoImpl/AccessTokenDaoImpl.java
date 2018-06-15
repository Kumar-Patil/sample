package com.taxi.daoImpl;

import com.taxi.dao.*;
import static com.taxi.daoImpl.UserDaoImpl.LOG;
import com.taxi.domain.AccessToken;
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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AccessTokenDaoImpl implements AccessTokenDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(AccessTokenDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean add(AccessToken accessToken) throws Exception {
        boolean isAdded = true;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(accessToken);
            tx.commit();
        } catch (HibernateException e) {
            isAdded = false;
            LOG.error("Exception occured while adding {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isAdded;
    }

    @Override
    public AccessToken findById(long id) throws Exception {
        AccessToken accessToken = null;
        try {
            session = sessionFactory.openSession();
            accessToken = (AccessToken) session.load(AccessToken.class,
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
        return accessToken;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AccessToken> list() throws Exception {
        List<AccessToken> accessTokens = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            accessTokens = session.createCriteria(User.class)
                    .list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return accessTokens;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean delete(long id)
            throws Exception {
        try {
            session = sessionFactory.openSession();
            Object o = session.load(AccessToken.class, id);
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
    public AccessToken ViewById(long id) throws Exception {
        AccessToken accessToken = null;
        try {
            session = sessionFactory.openSession();
            accessToken = (AccessToken) session.load(AccessToken.class, id);
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
        return accessToken;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean deleteAccessToken(long userId) throws Exception {
        boolean isdeletedAccessToken = false;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            Query query = session.createQuery("delete AccessToken accessToken where accessToken.userId = :userId");
            query.setParameter("userId", userId);
            int result = query.executeUpdate();
            tx.commit();
            isdeletedAccessToken = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting deleteAccessToken {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isdeletedAccessToken;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean isAccessTokenValid(long userId, String accessToken) throws Exception {
        boolean isValidAccessToken = false;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<AccessToken> accessList = null;
            String hql = null;
            hql = "from AccessToken accessToken where accessToken.accessToken =:accessToken and accessToken.userId =:userId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("accessToken", accessToken);
            query.setParameter("userId", userId);
            accessList = query.list();
            tx.commit();
            if (accessList.size() > 0) {
                isValidAccessToken = true;
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting isAccessToken {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isValidAccessToken;
    }
}
