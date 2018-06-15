package com.taxi.service;

import com.taxi.domain.AccessToken;
import java.util.List;

public interface AccessTokenService {

    public boolean add(AccessToken accessToken) throws Exception;

    public AccessToken findById(long id) throws Exception;

    public List<AccessToken> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public AccessToken viewById(long id) throws Exception;

    public boolean deleteAccessToken(long userId) throws Exception;

    public boolean isAccessTokenValid(long userId, String accessToken) throws Exception;
}
