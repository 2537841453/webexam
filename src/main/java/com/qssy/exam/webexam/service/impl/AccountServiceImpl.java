package com.qssy.exam.webexam.service.impl;

import com.qssy.exam.webexam.dao.AccountDao;
import com.qssy.exam.webexam.entity.Account;
import com.qssy.exam.webexam.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Override
    public Account findAccountByUsername(String username) {
        return accountDao.findAccountByUsername(username);
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public int deleteById(int id) {
        return accountDao.deleteById(id);
    }

    @Override
    public int saveAccount(String username, String password) {
        return accountDao.saveAccount(username,password);
    }

    @Override
    public int EditById(int id, String username, String password) {
        return accountDao.EditById(id,username,password);
    }

    @Override
    public Account findById(int id) {
        return null;
    }

   /* @Override
    public Account findById(int id) {
        return accountDao.findById(id);
    }*/
}
