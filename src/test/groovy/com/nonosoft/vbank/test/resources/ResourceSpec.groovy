package com.nonosoft.vbank.test.resources

import com.nonosoft.vbank.Application
import com.nonosoft.vbank.http.client.VBankClient
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
class ResourceSpec extends Specification {
    def client = new VBankClient('localhost', 8000)
}
