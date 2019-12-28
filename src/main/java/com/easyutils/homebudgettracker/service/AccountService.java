package com.easyutils.homebudgettracker.service;

import com.easyutils.homebudgettracker.domain.Account;
import com.easyutils.homebudgettracker.eao.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public String createAccount(Account account) {
        account.setUuid(UUID.randomUUID().toString());
        repository.save(account);
        return account.getUuid();
    }
}
