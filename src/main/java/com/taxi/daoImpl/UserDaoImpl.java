package com.taxi.daoImpl;

import com.taxi.RequestMapper.UserRequestMapper;
import com.taxi.dao.*;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.taxi.domain.User;
import com.taxi.to.RiderList;
import com.taxi.to.UserViewTo;
import com.taxi.to.VendorMap;
import com.taxi.util.Constants;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
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
    public boolean add(User user, long loggedInUser) throws Exception {
        boolean isAdded = false;
        Long userId = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            userId = (Long) session.save(user);
            tx.commit();
            isAdded = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while adding {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        if (isAdded) {
            this.userVendorMappingTable(loggedInUser, user.getId());
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
            hql = "from User user where user.status =:status";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("status", 1);
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
    public UserViewTo ViewById(long id) throws Exception {
        UserViewTo user = new UserViewTo();
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
                    user.setAccountNo(users.getAccountDetails().getAccountNo());
                    user.setAddress(users.getLocations().getStreet());
                    user.setAggrement1(users.getUserDocuments().getAggrement1());
                    user.setAggrement2(users.getUserDocuments().getAggrement2());
                    user.setAggrement4(users.getUserDocuments().getAggrement3());
                    user.setAggrement4(users.getUserDocuments().getAggrement4());
                    if (users.getLocations().getCities() != null) {
                        user.setCityName(users.getLocations().getCities().getCitieName());
                    }
                    if (users.getLocations().getCountries() != null) {
                        user.setCountryName(users.getLocations().getCountries().getName());
                    }
                    if (users.getLocations().getStates() != null) {
                        user.setStateName(users.getLocations().getStates().getState());
                    }
                    user.setEmail(users.getEmail());
                    user.setFirstName(users.getFirstName());
                    user.setHireDate(users.getHireDate());
                    user.setHireEndDate(users.getHireEndDate());
                    user.setIfsc(users.getAccountDetails().getIfsc());
                    user.setLastName(users.getLastName());
                    user.setName(users.getAccountDetails().getName());
                    user.setOtherphone(users.getOtherphone());
                    user.setPhone(users.getPhone());
                    user.setProofOfAddress(users.getUserDocuments().getProofOfAddress());
                    user.setRole(users.getRole());
                    user.setSex(users.getSex());
                    user.setStatus(Constants.status().get(users.getStatus()));
                    user.setStreet(users.getLocations().getStreet());
                    user.setUserPic(users.getUserDocuments().getUserPic());
                    user.setZip(users.getLocations().getZip());
                    user.setCreatedAt((Timestamp) users.getCreatedAt());
                    user.setUpdateAt(users.getUpdatedAt());
                    user.setDeletedAt(users.getDeletedAt());
                    /* Adding new field data */
                    user.setFatherName(users.getFather_name());
                    user.setCurrentpossition(users.getCurrent_possition());
                    user.setDob(users.getDob());
                    user.setLicenceNumber(users.getInsurance_number());
                    user.setLicenceExpiry(users.getLicence_expiry_date());
                    user.setInsuranceExpiry(users.getInsurance_expiry_Date());
                    user.setInsuranceNumber(users.getInsurance_number());
                    user.setPcoLicence(users.getUserDocuments().getPcoLicence());
                    user.setLicencePhoto(users.getUserDocuments().getLicencePhoto());
                    user.setLicencePaper(users.getUserDocuments().getLicencePaper());
                    user.setPoliceDisclose(users.getUserDocuments().getPoliceDisclose());
                    user.setInsurance(users.getUserDocuments().getInsurance());
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting ViewById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
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
    public boolean forgotPassword(String newPwd, String emailId, String otpValue) throws Exception {
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean changePassword(String newPwd, String emailId) throws Exception {
        boolean isUpdate = false;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String hql = "UPDATE User user set user.password =:newPwd "
                    + "WHERE user.email =:emailId ";
            Query query = session.createQuery(hql);
            query.setParameter("newPwd", newPwd);
            query.setParameter("emailId", emailId);
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
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean update(User user) throws Exception {
        boolean isAdded = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.update(user);
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
    public UserRequestMapper details(long id) throws Exception {
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
                    UserRequestMapper requestMapper = new UserRequestMapper();
                    requestMapper.setAccountNo(users.getAccountDetails().getAccountNo());
                    requestMapper.setAddress(users.getAccountDetails().getAdddress());
                    requestMapper.setAggrement1(users.getUserDocuments().getAggrement1());
                    requestMapper.setAggrement2(users.getUserDocuments().getAggrement2());
                    requestMapper.setAggrement3(users.getUserDocuments().getAggrement3());
                    requestMapper.setAggrement4(users.getUserDocuments().getAggrement4());
                    requestMapper.setEmail(users.getEmail());
                    requestMapper.setFirstName(users.getFirstName());
                    requestMapper.setHireDate(users.getHireDate());
                    requestMapper.setHireEndDate(users.getHireEndDate());
                    requestMapper.setIfsc(users.getAccountDetails().getIfsc());
                    requestMapper.setLastName(users.getLastName());
                    requestMapper.setName(users.getAccountDetails().getName());
                    requestMapper.setOtherphone(users.getOtherphone());
                    requestMapper.setPassword(users.getPassword());
                    requestMapper.setProofOfAddress(users.getUserDocuments().getProofOfAddress());
                    requestMapper.setRole(users.getRole());
                    requestMapper.setSex(users.getSex());
                    if (users.getLocations().getCities() != null) {
                        requestMapper.setCityId(users.getLocations().getCities().getCityId());
                    }
                    if (users.getLocations().getCountries() != null) {
                        requestMapper.setCountryId(users.getLocations().getCountries().getCountriId());
                    }
                    if (users.getLocations().getStates() != null) {
                        requestMapper.setStateId(users.getLocations().getStates().getStateId());
                    }
                    requestMapper.setStatus(users.getStatus());
                    requestMapper.setStreet(users.getLocations().getStreet());
                    requestMapper.setUserPic(users.getUserDocuments().getUserPic());
                    requestMapper.setZip(users.getLocations().getZip());
                    requestMapper.setId(users.getId());
                    requestMapper.setPhone(users.getPhone());

                    requestMapper.setFatherName(users.getFather_name());
                    requestMapper.setCurrentpossition(users.getCurrent_possition());
                    requestMapper.setDob(users.getDob());
                    requestMapper.setLicenceNumber(users.getInsurance_number());
                    requestMapper.setLicenceExpiry(users.getLicence_expiry_date());
                    requestMapper.setInsuranceExpiry(users.getInsurance_expiry_Date());
                    requestMapper.setInsuranceNumber(users.getInsurance_number());
                    requestMapper.setPcoLicence(users.getUserDocuments().getPcoLicence());
                    requestMapper.setLicencePhoto(users.getUserDocuments().getLicencePhoto());
                    requestMapper.setLicencePaper(users.getUserDocuments().getLicencePaper());
                    requestMapper.setPoliceDisclose(users.getUserDocuments().getPoliceDisclose());
                    requestMapper.setInsurance(users.getUserDocuments().getInsurance());
                    requestMapper.setOtherphone(users.getOtherphone());
                    return requestMapper;
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting ViewById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public void userVendorMappingTable(long userId, long vendorId) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            String sql = "insert into user_mapping(user_id,user_vendor_id) values(" + userId + "," + vendorId + ")";
            SQLQuery query = session.createSQLQuery(sql);
            query.executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while adding in userVendorMappingTable{}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getRoleType(long userId) throws Exception {
        String roleType = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            List<User> userList = null;
            String hql = null;
            hql = "from User user where user.id =:id";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("id", userId);
            userList = query.list();
            tx.commit();
            if (userList.size() > 0) {
                for (User users : userList) {
                    roleType = users.getRole();
                }
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting getRoleType {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return roleType;
    }

    @Override
    public List<VendorMap> roleBasedVendorList(long userId) throws Exception {
        List<VendorMap> vendorList = new ArrayList<>();
        try {
            String sqlQuery = null;
            String roleType = getRoleType(userId);
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            if (roleType.equalsIgnoreCase(Constants.SUPREME_USER) || roleType.equalsIgnoreCase(Constants.VIEW_USER)) {
                sqlQuery = "SELECT id as userId, role as role "
                        + ",phone as mobileNo,first_name as firstName,"
                        + "last_name as lastName, email as email, "
                        + "vendor_registration_no as vendorRegNo, status as status "
                        + "FROM users where role='Vendor' and status=1";
            } else {
                sqlQuery = "SELECT id as userId, role as role "
                        + ",phone as mobileNo,first_name as firstName, "
                        + "last_name as lastName, email as email, "
                        + "vendor_registration_no as vendorRegNo, status as status "
                        + "FROM users where role='Vendor' and status=1 and id in (select user_vendor_id from user_mapping where user_id = " + userId + " )";
            }
            vendorList = session.createSQLQuery(sqlQuery)
                    .addScalar("userId", StandardBasicTypes.LONG)
                    .addScalar("role")
                    .addScalar("mobileNo")
                    .addScalar("firstName")
                    .addScalar("lastName")
                    .addScalar("email")
                    .addScalar("vendorRegNo")
                    .addScalar("status")
                    .setResultTransformer(Transformers.aliasToBean(VendorMap.class))
                    .list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting roleBasedVendorList {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return vendorList;
    }

    @Override
    public List<RiderList> riders(long userId) throws Exception {
        List<RiderList> riderListList = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            String sqlQuery = null;
            sqlQuery = "SELECT id as userId, role as role "
                    + ",phone as mobileNo,first_name as firstName,"
                    + "last_name as lastName, email as email, "
                    + "vendor_registration_no as vendorRegNo, status as status "
                    + "FROM users where role='rider' and status=1";

            riderListList = session.createSQLQuery(sqlQuery)
                    .addScalar("userId", StandardBasicTypes.LONG)
                    .addScalar("role")
                    .addScalar("mobileNo")
                    .addScalar("firstName")
                    .addScalar("lastName")
                    .addScalar("email")
                    .addScalar("vendorRegNo")
                    .addScalar("status")
                    .setResultTransformer(Transformers.aliasToBean(RiderList.class))
                    .list();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting riderListList {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return riderListList;
    }
}
