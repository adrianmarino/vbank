package com.nonosoft.vbank.http.client;

import com.nonosoft.vbank.domain.models.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

public class VBankClient {

  public List<Account> accountsOnFirstPage() {
    return accountsByPage(0);
  }

  public List<Account> accountsByPage(Integer page) {
    ResponseEntity<Account[]> response = template.getForEntity(
        format("%s/accounts/pages/%s", baseUrl, page),
        Account[].class
    );
    return Arrays.asList(response.getBody());
  }

  public Account accountByCode(String code) {
    return template.getForObject(format("%s/accounts/%s", baseUrl, code), Account.class);
  }

  public void updateAccount(String code, String newCode) {
    template.put(format("%s/accounts/%s", baseUrl, code), new Account(newCode));
  }

  public Account createAccount(String code) {
    return template.postForObject(format("%s/accounts", baseUrl), new Account(code), Account.class);
  }

  public void deleteAccount(String code) {
    template.delete(format("%s/accounts/%s", baseUrl, code));
  }

  private final String baseUrl;

  private RestTemplate template;

  public VBankClient(String hostname, Integer port) {
    this.baseUrl = String.format("http://%s:%s", hostname, port);
    template = new RestTemplate();
  }
}
