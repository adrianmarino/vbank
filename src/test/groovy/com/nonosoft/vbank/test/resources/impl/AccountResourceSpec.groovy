package com.nonosoft.vbank.test.resources.impl

import com.nonosoft.vbank.test.resources.ResourceSpec

class AccountResourceSpec extends ResourceSpec {
    def "should create a new account"() {
        given:
            def code = 'adrian-marino'
        when:
            client.createAccount(code)
        then:
            client.accountByCode(code).code == code
        cleanup:
            client.deleteAccount(code)
    }

    def "should update account code"() {
        given:
            def code = 'adrian-marino'
            client.createAccount(code)
        and:
            def newCode = 'juan-perez'
        when:
            client.updateAccount(code, newCode)
        then:
            client.accountByCode(code) == null
            client.accountByCode(newCode) != null
        cleanup:
            client.deleteAccount(newCode)
    }

    def "should delete an account"() {
        given:
            def code = 'adrian-marino'
            client.createAccount(code)
        when:
            client.deleteAccount(code)
        then:
            client.accountByCode(code) == null
    }

    def "should get and accounts page"() {
        given:
            def code = 'adrian-marino'
            client.createAccount(code)
        when:
            def accounts = client.accountsOnFirstPage()
        then:
            accounts.any { it.code == code }
        cleanup:
            client.deleteAccount(code)
    }
}