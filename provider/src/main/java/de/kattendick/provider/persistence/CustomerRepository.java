package de.kattendick.provider.persistence;

import de.kattendick.provider.persistence.model.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

    List<CustomerEntity> findAll();

}
