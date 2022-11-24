package contracts.test

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name("contract_getAllCustomers")
    request {
        method 'GET'
        url '/all'
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status OK()
    }
}