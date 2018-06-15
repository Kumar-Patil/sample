package com.taxi.dao;

import com.taxi.domain.AccessToken;
import java.util.List;

public interface AccessTokenDao {

    public List<AccessToken> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public boolean add(AccessToken accessToken) throws Exception;

    public AccessToken findById(long id) throws Exception;

    public AccessToken ViewById(long id) throws Exception;

    public boolean deleteAccessToken(long userId) throws Exception;

    public boolean isAccessTokenValid(long userId, String accessToken) throws Exception;
}
