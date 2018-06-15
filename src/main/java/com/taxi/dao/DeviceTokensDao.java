package com.taxi.dao;

import com.taxi.domain.DeviceTokens;
import java.util.List;

public interface DeviceTokensDao {

    public List<DeviceTokens> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public boolean add(DeviceTokens deviceTokens) throws Exception;

    public DeviceTokens findById(long id) throws Exception;

    public DeviceTokens ViewById(long id) throws Exception;
}
