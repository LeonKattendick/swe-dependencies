# swe-dependencies
An example for consumer-driven contract testing with one provider and two consumers.

# Provider
Opens a REST-API on `http://localhost:8080/all` to fetch all customers with their products.

### Contract testing
In `provider/src/test/java/test/resources/contracts/tests/shouldReturnAllCustomers.groovy` you will find the provider test for the described endpoint. Maven will then compile this as stubs to use for the consumers.

# Consumer 1
Consumes the API and outputs the name, email and status of all customers on `http://localhost:8081/one`.

### Contract testing
In `consumer-one/src/test/java/test/ContractTest.java` you will find the consumer-one, which opens the stubbed endpoint and checks for the needed fields.

# Consumer 2
Consumes the API and outputs the name and aggregated balance of all customers and their products on `http://localhost:8082/two`.

### Contract testing
In `consumer-two/src/test/java/test/ContractTest.java` you will find the consumer-one, which opens the stubbed endpoint and checks for the needed fields.