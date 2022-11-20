package de.kattendick.tf.controller;

import de.kattendick.tf.persistence.model.response.CustomerResponse;
import de.kattendick.tf.persistence.model.response.CustomerWithBalanceResponse;
import de.kattendick.tf.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {

        List<CustomerResponse> responseList = customerService.getListOfAllCustomers()
                .stream()
                .map(v ->
                        CustomerResponse
                                .builder()
                                .name(v.getName())
                                .email(v.getEmail())
                                .status(v.getStatus())
                                .build()
                )
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/balance")
    public ResponseEntity<List<CustomerWithBalanceResponse>> getAllCustomersWithBalance() {

        List<CustomerWithBalanceResponse> responseList = customerService.getListOfAllCustomers()
                .stream()
                .map(v ->
                        CustomerWithBalanceResponse
                                .builder()
                                .name(v.getName())
                                .aggregatedBalance(customerService.calculateAggregatedBalanceForCustomer(v))
                                .build()
                )
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseList);
    }

    @PostMapping
    public ResponseEntity<String> addTestData() {

        customerService.addTestData();

        return ResponseEntity.ok("Done");
    }
}
