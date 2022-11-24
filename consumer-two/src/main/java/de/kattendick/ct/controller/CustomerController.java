package de.kattendick.ct.controller;

import de.kattendick.ct.model.CustomerEntity;
import de.kattendick.ct.model.ProductEntity;
import de.kattendick.ct.model.ResponseCustomer;
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

    @RequestMapping("/two")
    public ResponseEntity<List<ResponseCustomer>> getCustomer() {
        List<CustomerEntity> customer = restTemplate.exchange("http://localhost:8080/all",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<CustomerEntity>>() {
                }).getBody();

        return ResponseEntity.ok(customer.stream()
                .map(v -> ResponseCustomer.builder()
                        .name(v.getName())
                        .balance(v.getProductEntities().stream().mapToInt(ProductEntity::getBalance).sum())
                        .build())
                .collect(Collectors.toList()));
    }
}
