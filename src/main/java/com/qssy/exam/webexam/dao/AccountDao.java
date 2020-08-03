package com.qssy.exam.webexam.dao;

import com.qssy.exam.webexam.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountDao {
    Account findAccountByUsername(String username);
    List<Account> findAllAccount();
    int deleteById(int id);
    int saveAccount(@Param("username") String username, @Param("password") String password);
    int EditById(@Param("id") int id,@Param("username") String username, @Param("password") String password);
}
