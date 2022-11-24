package de.kattendick.provider.controller;

import de.kattendick.provider.persistence.model.CustomerEntity;
import de.kattendick.provider.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getListOfAllCustomers());
    }
}
