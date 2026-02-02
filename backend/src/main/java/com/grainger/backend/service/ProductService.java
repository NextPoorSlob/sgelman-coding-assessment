package com.grainger.backend.service;

import com.grainger.backend.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product add(String name) throws Exception;
}
