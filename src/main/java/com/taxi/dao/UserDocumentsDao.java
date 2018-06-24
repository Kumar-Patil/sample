package com.taxi.dao;

import com.taxi.domain.UserDocuments;
import java.util.List;

public interface UserDocumentsDao {

    public List<UserDocuments> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public long add(UserDocuments userDocuments) throws Exception;

    public UserDocuments findById(long id) throws Exception;

    public UserDocuments ViewById(long id) throws Exception;

    public boolean updateStatus(long driverId) throws Exception;
    
    public boolean update(UserDocuments userDocuments) throws Exception;
}
