package com.nonosoft.vbank.services;

import com.nonosoft.vbank.models.Account;
import com.nonosoft.vbank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AccountCrudService {

    public Account create(String code) {
        return repository.save(new Account(code));
    }

    public Page<Account> all(Integer page) {
        return repository.findAll(new PageRequest(page, SIZE));
    }

    private static final int SIZE = 20;

    @Autowired
    private AccountRepository repository;
}
