package com.nonosoft.vbank.test.resources

class AccountResourceSpec extends ResourceSpec {
    def "should create a new account"() {
        given: 'an account code'
            def code = 'adrian-marino'

        when: 'create new account with the code'
            client.createAccount(code)

        then: 'should exists an account with code'
            client.accountByCode(code).getCode() == code

        cleanup:
            client.deleteAccount(code)
    }
}