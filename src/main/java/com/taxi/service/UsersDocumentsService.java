package com.taxi.service;

import com.taxi.domain.UserDocuments;
import java.util.List;

public interface UsersDocumentsService {

    public long add(UserDocuments userDocuments) throws Exception;

    public UserDocuments findById(long id) throws Exception;

    public List<UserDocuments> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public UserDocuments viewById(long id) throws Exception;

    public boolean updateStatus(long driverId) throws Exception;
    
    public boolean update(UserDocuments userDocuments) throws Exception;
}
