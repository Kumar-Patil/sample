package com.taxi.service;

import com.taxi.domain.BankAccountDetails;
import java.util.List;

public interface BankAccountDetailsService {

    public Long add(BankAccountDetails bankAccountDetails) throws Exception;

    public BankAccountDetails findById(long id) throws Exception;

    public List<BankAccountDetails> list() throws Exception;

    public boolean delete(long id) throws Exception;

    public BankAccountDetails viewById(long id) throws Exception;

    public boolean update(BankAccountDetails bankAccountDetails) throws Exception;
}
