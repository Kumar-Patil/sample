package com.taxi.serviceImpl;

import com.taxi.RequestMapper.UserRequestMapper;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.domain.User;
import com.taxi.dao.UserDao;
import com.taxi.service.UserService;

public class UserServicesImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> list() throws Exception {
        return userDao.list();
    }

    @Override
    public boolean delete(long id) throws Exception {
        return userDao.delete(id);
    }

    @Override
    public boolean add(User user) throws Exception {
        return userDao.add(user);
    }

    @Override
    public User findById(long id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public User viewById(long id) throws Exception {
        return userDao.ViewById(id);
    }

    @Override
    public long isValidUser(String emailId, String password) throws Exception {
        return userDao.isValidUser(emailId, password);
    }

    @Override
    public boolean isValidEmailId(String emailId) throws Exception {
        return userDao.isValidEmailId(emailId);
    }

    @Override
    public boolean updateOTP(String emailId, String OTPValue) throws Exception {
        return userDao.updateOTP(emailId, OTPValue);
    }

    @Override
    public boolean OTPVerification(String emailId, String OTPValue) throws Exception {
        return userDao.OTPVerification(emailId, OTPValue);
    }

    @Override
    public boolean forgotPassword(String newPwd, String emailId, String otpValue) throws Exception {
        return userDao.forgotPassword(newPwd, emailId, otpValue);
    }

    @Override
    public boolean updateStatus(long userId) throws Exception {
        return userDao.updateStatus(userId);
    }

    @Override
    public List<User> search(String searchVal) throws Exception {
        return userDao.search(searchVal);
    }

    @Override
    public List<User> getAll() throws Exception {
        return userDao.getAll();
    }

    @Override
    public boolean changePassword(String newPwd, String emailId) throws Exception {
        return userDao.changePassword(newPwd, emailId);
    }

    @Override
    public boolean update(User user) throws Exception {
        return userDao.update(user);
    }

    @Override
    public UserRequestMapper details(long id) throws Exception {
        return userDao.details(id);
    }

}
