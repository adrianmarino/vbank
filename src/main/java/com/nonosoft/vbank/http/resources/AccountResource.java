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
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/accounts")
public class AccountResource {

  @RequestMapping(value = "/pages/{page}")
  public ResponseEntity<List<Account>> pages(@PathVariable Integer page) {
    return ResponseUtils.toPageResponse(service.findByPage(page));
  }

  @RequestMapping(value = "/{code}")
  public ResponseEntity<Account> read(@PathVariable String code) {
    return new ResponseEntity<>(service.findByCode(code), OK);
  }

  @RequestMapping(value = "/{code}", method = PUT)
  public ResponseEntity update(@PathVariable String code, @RequestBody CreateAccountRequest request) {
    service.update(code, request.getCode());
    return new ResponseEntity(OK);
  }

  @RequestMapping(method = POST)
  public ResponseEntity<Void> create(@RequestBody CreateAccountRequest request) {
    service.create(request.getCode());
    return new ResponseEntity<>(OK);
  }

  @RequestMapping(value = "/{code}", method = DELETE)
  public ResponseEntity<Void> delete(@PathVariable String code) {
    service.remove(code);
    return new ResponseEntity<>(OK);
  }

  @Autowired
  private AccountCrudService service;
}
