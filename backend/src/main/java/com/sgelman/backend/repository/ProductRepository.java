package com.sgelman.backend.repository;

import com.sgelman.backend.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE LOWER(p.productName) = LOWER(:productName)")
    List<Product> findByName(String productName);
}
