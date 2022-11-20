package de.kattendick.tf.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerEntity {

    @Id
    private Long id;

    private String address;

    private Date dateOfBirth;

    private String email;

    private String status;

    @OneToMany(mappedBy = "customer")
    private List<ProductEntity> productEntities;

}
