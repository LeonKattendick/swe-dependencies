# swe-dependencies
An example for consumer-driven contract testing with one provider and two consumers.

# Provider
Opens a REST-API on `http://localhost:8080/all` to fetch all customers with their products.

# Consumer 1
Consumes the API and outputs the name, email and status of all customers on `http://localhost:8081/one`.

# Consumer 2
Consumes the API and outputs the name and aggregated balance of all customers and their products on `http://localhost:8082/two`.