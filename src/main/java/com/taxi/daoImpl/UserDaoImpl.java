package com.taxi.daoImpl;

import com.taxi.dao.*;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.taxi.domain.User;
import java.sql.Timestamp;
import java.util.Calendar;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(UserDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean add(User user) throws Exception {
        boolean isAdded = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(user);
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
    public User findById(long id) throws Exception {
        User user = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<User> userList = null;
            String hql = null;
            hql = "from User user where user.id =:userId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("userId", id);
            userList = query.list();
            tx.commit();
            if (userList.size() > 0) {
                for (User users : userList) {
                    return users;
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> list() throws Exception {
        List<User> userList = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = null;
            hql = "from User";
            Query query = (Query) session.createQuery(hql);
            userList = query.list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting list {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userList;
    }

    @Override
    @Cascade({CascadeType.DELETE})
    public boolean delete(long id)
            throws Exception {
        try {
            session = sessionFactory.openSession();
            Object o = session.load(User.class, id);
            tx = session.getTransaction();
            session.beginTransaction();
            session.delete(o);
            tx.commit();
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
    public User ViewById(long id) throws Exception {
        List<User> user = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<User> userList = null;
            String hql = null;
            hql = "from User user where user.id =:id";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("id", id);
            userList = query.list();
            tx.commit();
            if (userList.size() > 0) {
                for (User users : userList) {
                    return users;
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting ViewById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return (User) user;
    }

    @SuppressWarnings("unchecked")
    @Override
    public long isValidUser(String emailId, String password) throws Exception {
        long userId = 0;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<User> userList = null;
            String hql = null;
            hql = "from User user where user.email =:emailId and user.password =:password";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("emailId", emailId);
            query.setParameter("password", password);
            userList = query.list();
            tx.commit();
            if (userList.size() > 0) {
                for (User users : userList) {
                    userId = users.getId();
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting isValidUser {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userId;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean isValidEmailId(String emailId) throws Exception {
        boolean isValidEmailID = false;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<User> userList = null;
            String hql = null;
            hql = "from User user where user.email =:emailId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("emailId", emailId);
            userList = query.list();
            tx.commit();
            if (userList.size() > 0) {
                isValidEmailID = true;
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting isValidUser {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isValidEmailID;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean updateOTP(String emailId, String OTPValue) throws Exception {
        boolean isOTPUpdated = false;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = "UPDATE User user set user.OTPValue =:OTPValue "
                    + "WHERE user.email =:emailId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("emailId", emailId);
            query.setParameter("OTPValue", OTPValue);
            query.setParameter("emailId", emailId);
            query.executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting isValidUser {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return isOTPUpdated;

    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean OTPVerification(String emailId, String OTPValue) throws Exception {
        boolean isValidOTP = false;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<User> userList = null;
            String hql = null;
            hql = "from User user where user.email =:emailId and user.OTPValue =:OTPValue";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("emailId", emailId);
            query.setParameter("OTPValue", OTPValue);
            userList = query.list();
            tx.commit();
            if (userList.size() > 0) {
                isValidOTP = true;
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting isValidUser {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isValidOTP;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean changePassword(String newPwd, String emailId, String otpValue) throws Exception {
        boolean isUpdate = false;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = "UPDATE User user set user.password =:newPwd "
                    + "WHERE user.email =:emailId and user.OTPValue =:otpValue";
            Query query = session.createQuery(hql);
            query.setParameter("newPwd", newPwd);
            query.setParameter("emailId", emailId);
            query.setParameter("otpValue", otpValue);
            int i = query.executeUpdate();
            String deleteOtp = "UPDATE User user SET user.OTPValue = NULL WHERE user.OTPValue = '" + otpValue + "'";
            Query deleteOTPquery = session.createQuery(deleteOtp);
            if (i > 0) {
                deleteOTPquery.executeUpdate();
                isUpdate = true;
            }
            tx.commit();

        } catch (HibernateException e) {
            LOG.error("Exception occured while getting changePassword {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isUpdate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean updateStatus(long userId) throws Exception {
        boolean isStatusUpdated = false;
        try {
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = "UPDATE User user set user.status =:status,user.deletedAt =:deletedAt "
                    + "WHERE user.id =:userId";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("userId", userId);
            query.setParameter("status", 0);
            query.setParameter("deletedAt", currentTimestamp);
            query.executeUpdate();
            tx.commit();
            isStatusUpdated = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting updateStatus {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return isStatusUpdated;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public List<User> search(String searchVal) throws Exception {
        List<User> userList = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = null;
            hql = "from User user where user.email like "
                    + "'" + searchVal + "%' or user.role like '" + searchVal + "%' "
                    + "or user.phone like '" + searchVal + "%' "
                    + "or user.firstName like '" + searchVal + "%' or user.lastName like '" + searchVal + "%'";
            Query query = (Query) session.createQuery(hql);
            userList = query.list();

        } catch (HibernateException e) {
            LOG.error("Exception occured while getting search {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userList;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public List<User> getAll() throws Exception {
        List<User> userList = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = null;
            hql = "from User";
            Query query = (Query) session.createQuery(hql);
            userList = query.list();

        } catch (HibernateException e) {
            LOG.error("Exception occured while getting getAll {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userList;
    }
}
