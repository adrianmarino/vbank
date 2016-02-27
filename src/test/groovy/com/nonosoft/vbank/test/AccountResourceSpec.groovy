package com.nonosoft.vbank.test

import com.nonosoft.vbank.Application
import com.nonosoft.vbank.domain.services.AccountCrudService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.transaction.annotation.EnableTransactionManagement
import spock.lang.Specification
import spock.lang.Stepwise
import groovyx.net.http.RESTClient
import org.springframework.transaction.annotation.Transactional

@ContextConfiguration(loader = SpringApplicationContextLoader, classes = [Application])
@WebAppConfiguration
@IntegrationTest("server.port:8000")
@Stepwise
class AccountResourceSpec extends Specification {

    @Autowired
    def AccountCrudService service;

    def "should create a new account"() {
        given:
            def client = new RESTClient('http://localhost:8000')
            def code = 'adrian-marino'

        when:
            def response = client.post([path: "/accounts", contentType: 'application/json', body: [code: code]])

        then:
            response.status == 200
            service.findByCode(code) != null

        cleanup:
            service.remove(code)
    }
}