package com.nonosoft.vbank.test.resources.impl

import com.nonosoft.vbank.test.resources.ResourceSpec

class AccountResourceSpec extends ResourceSpec {
  def "create a new account"() {
    given: "an account code"
      def code = '123'
    when: "create a new account with the code"
      client.createAccount(code)
    then: "should exits a new account with the code"
      client.accountByCode(code).code == code
    cleanup:
      client.deleteAccount(code)
  }

  def "update account code"() {
    given: "a pre-existent account"
      def code = '123'
      client.createAccount(code)
    and: "a new code"
      def newCode = 'juan-perez'
    when: "update account with the new code"
      client.updateAccount(code, newCode)
    then: "shouldn't exits an account with old code"
      client.accountByCode(code) == null
    and: "should exist an account with the new code"
      client.accountByCode(newCode) != null
    cleanup:
      client.deleteAccount(newCode)
  }

  def "delete an account"() {
    given: "a pre-existent account"
      def code = '123'
      client.createAccount(code)
    when: "delete the account with a code"
      client.deleteAccount(code)
    then: "shouldn't exits any account with the code"
      client.accountByCode(code) == null
  }

  def "get accounts page"() {
    given: "a pre-existent account"
      def code = '123'
      client.createAccount(code)
    when: "get first accounts page"
      def page = client.accountsOnFirstPage()
    then: "the page should contains the account"
      page.any { it.code == code }
    cleanup:
      client.deleteAccount(code)
  }
}