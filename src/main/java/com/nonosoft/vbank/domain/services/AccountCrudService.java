package com.nonosoft.vbank.domain.services;

import com.nonosoft.vbank.domain.models.Account;
import com.nonosoft.vbank.domain.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AccountCrudService {

    public Page<Account> findByPage(Integer page) {
        return repository.findAll(new PageRequest(page, SIZE));
    }

    public Account create(String code) {
        return repository.save(new Account(code));
    }

    public void remove(String code) {
        repository.delete(repository.findByCode(code));
    }

    public Account findByCode(String code) {
        return repository.findByCode(code);
    }

    private static final int SIZE = 20;

    @Autowired
    private AccountRepository repository;
}
