package com.nonosoft.vbank.domain.repositories;

import com.nonosoft.vbank.domain.models.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByCode(String code);

    Page<Account> findAll(Pageable pageable);
}