package com.nonosoft.vbank.http.resources;

import com.nonosoft.vbank.domain.models.Account;
import com.nonosoft.vbank.http.response.ResponseUtils;
import com.nonosoft.vbank.http.request.CreateAccountRequest;
import com.nonosoft.vbank.domain.services.AccountCrudService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/accounts")
public class AccountResource {

    @RequestMapping(value = "/pages/{page}")
    public ResponseEntity<List<Account>> pages(@PathVariable Integer page) {
        return ResponseUtils.toPageResponse(service.findByPage(page));
    }

    @RequestMapping(method = POST)
    public ResponseEntity<Void> create(@RequestBody CreateAccountRequest request) {
        service.create(request.getCode());
        return new ResponseEntity<>(OK);
    }

    @RequestMapping(value = "/{code}", method = DELETE)
    public ResponseEntity<Void> remove(@PathVariable String code) {
        service.remove(code);
        return new ResponseEntity<>(OK);
    }

    @Autowired
    private AccountCrudService service;
}
