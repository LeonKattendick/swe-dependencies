package de.kattendick.tf.service;

import de.kattendick.tf.persistence.CustomerRepository;
import de.kattendick.tf.persistence.model.CustomerEntity;
import de.kattendick.tf.persistence.model.ProductEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public List<CustomerEntity> getListOfAllCustomers() {
        return customerRepository.findAll();
    }

    public int calculateAggregatedBalanceForCustomer(CustomerEntity customer) {
        return customer.getProductEntities().stream().mapToInt(ProductEntity::getBalance).sum();
    }

    public void addTestData() {

        ProductEntity product1 = ProductEntity.builder()
                .name("Produkt 1")
                .balance(1200)
                .productCode(123)
                .interestRate(1D)
                .build();

        ProductEntity product2 = ProductEntity.builder()
                .name("Produkt 2")
                .balance(300)
                .productCode(234)
                .interestRate(1.5D)
                .build();

        ProductEntity product3 = ProductEntity.builder()
                .name("Produkt 3")
                .balance(530)
                .productCode(345)
                .interestRate(1.1D)
                .build();

        CustomerEntity customer1 = CustomerEntity.builder()
                .name("Max")
                .address("Musterstraße 1")
                .dateOfBirth(new Date(System.currentTimeMillis()))
                .email("mail@mail.at")
                .status("ACTIVE")
                .productEntities(Arrays.asList(product1, product2))
                .build();

        CustomerEntity customer2 = CustomerEntity.builder()
                .name("Peter")
                .address("Musterstraße 2")
                .dateOfBirth(new Date(System.currentTimeMillis()))
                .email("mail2@mail.at")
                .status("ACTIVE")
                .productEntities(Collections.singletonList(product3))
                .build();

        product1.setCustomer(customer1);
        product2.setCustomer(customer1);
        product3.setCustomer(customer2);

        customerRepository.save(customer1);
        customerRepository.save(customer2);

    }
}
