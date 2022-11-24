package de.kattendick.dependencies.controller;

import de.kattendick.dependencies.persistence.model.CustomerEntity;
import de.kattendick.dependencies.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public ResponseEntity<String> addTestData() {

        customerService.addTestData();

        return ResponseEntity.ok("Done");
    }
}
