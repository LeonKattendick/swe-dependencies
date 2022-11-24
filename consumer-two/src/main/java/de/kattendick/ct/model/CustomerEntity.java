package de.kattendick.ct.model;

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

    private String dateOfBirth;

    private String email;

    private String status;

    private List<ProductEntity> productEntities;

}
