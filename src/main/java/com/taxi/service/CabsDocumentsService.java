package com.taxi.service;

import com.taxi.domain.CabDocuments;
import java.util.List;

public interface CabsDocumentsService {

    public boolean add(CabDocuments cabDocuments) throws Exception;

    public CabDocuments findById(long id) throws Exception;

    public List<CabDocuments> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public CabDocuments viewById(long id) throws Exception;

    public boolean updateStatus(long cabId) throws Exception;

}
