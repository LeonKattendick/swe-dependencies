package de.kattendick.provider.service;

import de.kattendick.provider.persistence.model.CustomerEntity;
import de.kattendick.provider.persistence.model.ProductEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    public List<CustomerEntity> getListOfAllCustomers() {

        ProductEntity product1 = ProductEntity.builder()
                .id(1L)
                .name("Produkt 1")
                .balance(1200)
                .productCode(123)
                .interestRate(1D)
                .build();

        ProductEntity product2 = ProductEntity.builder()
                .id(2L)
                .name("Produkt 2")
                .balance(300)
                .productCode(234)
                .interestRate(1.5D)
                .build();

        ProductEntity product3 = ProductEntity.builder()
                .id(3L)
                .name("Produkt 3")
                .balance(530)
                .productCode(345)
                .interestRate(1.1D)
                .build();

        CustomerEntity customer1 = CustomerEntity.builder()
                .id(1L)
                .name("Max")
                .address("Musterstraße 1")
                .dateOfBirth(new Date(System.currentTimeMillis()))
                .email("mail@mail.at")
                .status("ACTIVE")
                .productEntities(Arrays.asList(product1, product2))
                .build();

        CustomerEntity customer2 = CustomerEntity.builder()
                .id(2L)
                .name("Peter")
                .address("Musterstraße 2")
                .dateOfBirth(new Date(System.currentTimeMillis()))
                .email("mail2@mail.at")
                .status("ACTIVE")
                .productEntities(Collections.singletonList(product3))
                .build();

        return Arrays.asList(customer1, customer2);
    }
}
