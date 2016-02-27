package com.nonosoft.vbank.test

import com.nonosoft.vbank.Application
import com.nonosoft.vbank.domain.services.AccountCrudService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification
import spock.lang.Stepwise

@ContextConfiguration(loader = SpringApplicationContextLoader, classes = [Application])
@WebAppConfiguration
@IntegrationTest("server.port:8000")
@Stepwise
class AccountCrdServiceSpec extends Specification {

    @Autowired
    def AccountCrudService target;

    def "let's try this!"() {
        expect:
        Math.max(1, 2) == 2
    }
}