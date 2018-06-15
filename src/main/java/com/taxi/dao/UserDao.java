package com.taxi.dao;

import java.util.List;

import com.taxi.domain.User;

public interface UserDao {

    public List<User> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public boolean add(User user) throws Exception;

    public User findById(long id) throws Exception;

    public User ViewById(long id) throws Exception;

    long isValidUser(String emailId, String password) throws Exception;

    public boolean isValidEmailId(String emailId) throws Exception;

    public boolean updateOTP(String emailId, String OTPValue) throws Exception;

    public boolean OTPVerification(String emailId, String OTPValue) throws Exception;

    public boolean changePassword(String newPwd, String emailId, String otpValue) throws Exception;

    public boolean updateStatus(long userId) throws Exception;

    public List<User> search(String searchVal) throws Exception;

    public List<User> getAll() throws Exception;

}
