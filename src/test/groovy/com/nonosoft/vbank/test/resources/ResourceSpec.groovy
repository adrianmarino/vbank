package com.nonosoft.vbank.test.resources

import com.nonosoft.vbank.Application
import com.nonosoft.vbank.http.client.VBankClient
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise
import spock.lang.Unroll

@ContextConfiguration(loader = SpringApplicationContextLoader, classes = [Application])
@WebAppConfiguration
@IntegrationTest("server.port:8000")
@Stepwise
@Unroll
class ResourceSpec extends Specification {
    static final HOSTNAME = 'localhost'
    static final PORT = 8000
    @Shared def client = new VBankClient(HOSTNAME, PORT)
}
