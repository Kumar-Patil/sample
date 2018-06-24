package com.taxi.dao;

import com.taxi.domain.BankAccountDetails;
import java.util.List;

public interface BankAccountDetailsDao {

    public List<BankAccountDetails> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public Long add(BankAccountDetails bankAccountDetails) throws Exception;

    public BankAccountDetails findById(long id) throws Exception;

    public BankAccountDetails ViewById(long id) throws Exception;

    public boolean update(BankAccountDetails bankAccountDetails) throws Exception;
}
