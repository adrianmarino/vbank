package com.nonosoft.vbank.repositories;

import com.nonosoft.vbank.models.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByCode(String code);

    Page<Account> findAll(Pageable pageable);
}