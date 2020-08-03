package com.qssy.exam.webexam.service;

import com.qssy.exam.webexam.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountService {
    Account findAccountByUsername(String username);
    List<Account> findAllAccount();
    int deleteById(int id);
    int saveAccount(String username,String password);
    int EditById(int id,String username,String password);
    Account findById(int id);
}
