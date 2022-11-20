package de.kattendick.tf.service;

import de.kattendick.tf.persistence.CustomerRepository;
import de.kattendick.tf.persistence.model.CustomerEntity;
import de.kattendick.tf.persistence.model.ProductEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
