package de.kattendick.co.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

    private Long id;

    private String name;

    private String address;

    private Date dateOfBirth;

    private String email;

    private String status;

    private List<ProductEntity> productEntities;

}
