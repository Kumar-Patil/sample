package com.taxi.dao;

import com.taxi.domain.UserOnline;
import java.util.List;

public interface UserOnlineDao {

    public List<UserOnline> list() throws Exception;

    public Long add(UserOnline userOnline) throws Exception;

    public UserOnline findById(long id) throws Exception;

    public boolean update(UserOnline userOnline) throws Exception;
}
