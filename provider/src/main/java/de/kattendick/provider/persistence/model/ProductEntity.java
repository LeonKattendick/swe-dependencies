package de.kattendick.provider.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {

    private Long id;

    private String name;

    private Integer balance;

    private Integer productCode;

    private Double interestRate;

}
