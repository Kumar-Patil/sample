package com.taxi.service;

import com.taxi.domain.UserOnline;
import java.util.List;

public interface UserOnlineService {

    public Long add(UserOnline userOnline) throws Exception;

    public UserOnline findById(long id) throws Exception;

    public List<UserOnline> list() throws Exception;

    public boolean update(UserOnline userOnline) throws Exception;
}
