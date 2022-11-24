package de.kattendick.co.controller;

import de.kattendick.co.model.CustomerEntity;
import de.kattendick.co.model.ResponseCustomer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    private final RestTemplate restTemplate;

    private CustomerController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @RequestMapping("/one")
    public ResponseEntity<List<ResponseCustomer>> getCustomer() {
        List<CustomerEntity> customer = restTemplate.exchange("http://localhost:8080/all",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<CustomerEntity>>() {
                }).getBody();

        return ResponseEntity.ok(customer.stream()
                .map(v -> ResponseCustomer.builder()
                        .name(v.getName())
                        .email(v.getEmail())
                        .status(v.getStatus())
                        .build())
                .collect(Collectors.toList()));
    }
}
