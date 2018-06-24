package com.taxi.serviceImpl;

import com.taxi.dao.BankAccountDetailsDao;
import com.taxi.domain.BankAccountDetails;
import com.taxi.service.BankAccountDetailsService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class BankAccountDetailsServicesImpl implements BankAccountDetailsService {

    @Autowired
    BankAccountDetailsDao accountDetailsDao;

    @Override
    public List<BankAccountDetails> list() throws Exception {
        return accountDetailsDao.list();
    }

    @Override
    public boolean delete(long id) throws Exception {
        return accountDetailsDao.delete(id);
    }

    @Override
    public Long add(BankAccountDetails bankAccountDetails) throws Exception {
        return accountDetailsDao.add(bankAccountDetails);
    }

    @Override
    public BankAccountDetails findById(long id) throws Exception {
        return accountDetailsDao.findById(id);
    }

    @Override
    public BankAccountDetails viewById(long id) throws Exception {
        return accountDetailsDao.ViewById(id);
    }

    @Override
    public boolean update(BankAccountDetails bankAccountDetails) throws Exception {
        return accountDetailsDao.update(bankAccountDetails);
    }

}
