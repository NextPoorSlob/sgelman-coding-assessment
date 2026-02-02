package com.sgelman.backend.service;

import com.sgelman.backend.model.Product;
import com.sgelman.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceUsingSqlDatabase implements  ProductService {

    private final ProductRepository productRepository;

    public ProductServiceUsingSqlDatabase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product add(String name) {
        return productRepository.save(new Product(name));
    }
}
