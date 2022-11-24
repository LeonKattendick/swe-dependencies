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
        body([[
                      id             : anyInteger(),
                      name           : anyNonEmptyString(),
                      address        : anyNonEmptyString(),
                      dateOfBirth    : anyNonEmptyString(),
                      email          : anyNonEmptyString(),
                      status         : anyNonEmptyString(),
                      productEntities: [[
                                                "id"          : anyInteger(),
                                                "name"        : anyNonEmptyString(),
                                                "balance"     : anyInteger(),
                                                "productCode" : anyInteger(),
                                                "interestRate": anyDouble()
                                        ]]
              ]])
    }
}