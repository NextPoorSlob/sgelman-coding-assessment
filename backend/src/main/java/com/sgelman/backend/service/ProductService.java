package com.sgelman.backend.service;

import com.sgelman.backend.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product add(String name) throws Exception;
}
