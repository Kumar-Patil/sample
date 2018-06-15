package com.taxi.serviceImpl;

import com.taxi.dao.AccessTokenDao;
import com.taxi.domain.AccessToken;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.service.AccessTokenService;

public class AccessTokenServicesImpl implements AccessTokenService {

    @Autowired
    AccessTokenDao accessTokenDao;

    @Override
    public List<AccessToken> list() throws Exception {
        return accessTokenDao.list();
    }

    @Override
    public boolean delete(long id) throws Exception {
        return accessTokenDao.delete(id);
    }

    @Override
    public boolean add(AccessToken accessToken) throws Exception {
        return accessTokenDao.add(accessToken);
    }

    @Override
    public AccessToken findById(long id) throws Exception {
        return accessTokenDao.findById(id);
    }

    @Override
    public AccessToken viewById(long id) throws Exception {
        return accessTokenDao.ViewById(id);
    }

    @Override
    public boolean deleteAccessToken(long userId) throws Exception {
        return accessTokenDao.deleteAccessToken(userId);
    }

    @Override
    public boolean isAccessTokenValid(long userId, String accessToken) throws Exception {
        return accessTokenDao.isAccessTokenValid(userId, accessToken);
    }

}
