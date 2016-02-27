package com.nonosoft.vbank.rest.controller;

import com.nonosoft.vbank.models.Account;
import com.nonosoft.vbank.rest.ResponseUtils;
import com.nonosoft.vbank.rest.request.CreateAccountRequest;
import com.nonosoft.vbank.services.AccountCrudService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @RequestMapping(method = POST)
    public ResponseEntity<Void> create(@RequestBody CreateAccountRequest request) {
        service.create(request.getCode());
        return new ResponseEntity<Void>(OK);
    }

    @RequestMapping(value = "/pages/{page}", method = GET)
    public ResponseEntity<List<Account>> all(@PathVariable Integer page) throws Exception {
        return ResponseUtils.toPageResponse(service.findByPage(page));
    }

    @Autowired
    private AccountCrudService service;
}
