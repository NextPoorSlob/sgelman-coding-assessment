package com.sgelman.backend.service;

import com.sgelman.backend.model.Product;
import com.sgelman.backend.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.postgresql.util.PSQLException;
import org.postgresql.util.PSQLState;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceUsingSqlDatabaseTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    void setup() {
        productService = new ProductServiceUsingSqlDatabase(productRepository);
    }

    @Test
    void testGetAllProductsNothingFound() {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());

        List<Product> products = productService.getAllProducts();

        assertTrue(products.isEmpty());
    }

    @Test
    void testGetAllProductsProductsFound() {
        when(productRepository.findAll()).thenReturn(
                List.of(
                        new Product(1L, "Sample Product"),
                        new Product(2L, "Another Product")
                ));

        List<Product> products = productService.getAllProducts();

        assertFalse(products.isEmpty());
        assertTrue(products.contains(new Product(1L, "Sample Product")));
        assertTrue(products.contains(new Product(2L, "Another Product")));
    }

    @Test
    void addSuccessfully() {
        Product newProduct = new Product("New Product");
        Product savedProduct = new Product(1L, "New Product");

        try {
            when(productRepository.save(newProduct)).thenReturn(savedProduct);

            Product result = productService.add("New Product");

            assertEquals(result, savedProduct);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    void addFailsDuplicateKey() {
        Product newProduct = new Product("New Product");

        when(productRepository.save(newProduct)).thenThrow(
                new RuntimeException(new PSQLException("Duplicate key, you lamebrain!", PSQLState.UNIQUE_VIOLATION)));

        assertThrows(RuntimeException.class, () -> productService.add("New Product"));
    }
}