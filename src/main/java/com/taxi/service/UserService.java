package com.taxi.service;

import com.taxi.RequestMapper.UserRequestMapper;
import java.util.List;

import com.taxi.domain.User;
import com.taxi.to.UserViewTo;
import com.taxi.to.VendorMap;

public interface UserService {

    public boolean add(User user, long loggedInUser) throws Exception;

    public User findById(long id) throws Exception;

    public List<User> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public UserViewTo viewById(long id) throws Exception;

    long isValidUser(String emailId, String password) throws Exception;

    public boolean isValidEmailId(String emailId) throws Exception;

    public boolean updateOTP(String emailId, String OTPValue) throws Exception;

    public boolean OTPVerification(String emailId, String OTPValue) throws Exception;

    public boolean forgotPassword(String newPwd, String emailId, String otpValue) throws Exception;

    public boolean updateStatus(long userId) throws Exception;

    public List<User> search(String searchVal) throws Exception;

    public List<User> getAll() throws Exception;

    public boolean changePassword(String newPwd, String emailId) throws Exception;

    public boolean update(User user) throws Exception;

    public UserRequestMapper details(long id) throws Exception;

    public String getRoleType(long userId) throws Exception;
    public List<VendorMap> roleBasedVendorList(long userId) throws Exception;
}
