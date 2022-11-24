package de.kattendick.ct.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    private Long id;

    private String name;

    private Integer balance;

    private Integer productCode;

    private Double interestRate;

}
