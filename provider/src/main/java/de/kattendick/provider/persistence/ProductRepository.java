package de.kattendick.provider.persistence;

import de.kattendick.provider.persistence.model.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

}
