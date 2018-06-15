package com.taxi.service;

import com.taxi.domain.DeviceTokens;
import java.util.List;

public interface DeviceTokensService {

    public boolean add(DeviceTokens deviceTokens) throws Exception;

    public DeviceTokens findById(long id) throws Exception;

    public List<DeviceTokens> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public DeviceTokens viewById(long id) throws Exception;
}
