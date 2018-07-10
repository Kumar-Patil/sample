package com.taxi.dao;

import com.taxi.domain.CabDocuments;
import java.util.List;

public interface CabsDocumentsDao {

    public List<CabDocuments> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public Long add(CabDocuments cabDocuments) throws Exception;

    public CabDocuments findById(long id) throws Exception;

    public CabDocuments ViewById(long id) throws Exception;

    public boolean updateStatus(long documentId) throws Exception;
    public boolean update(CabDocuments cabDocuments) throws Exception;

}
