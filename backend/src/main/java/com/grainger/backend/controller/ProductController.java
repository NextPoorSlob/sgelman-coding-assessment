package com.grainger.backend.controller;

import com.grainger.backend.model.Product;
import com.grainger.backend.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// OpenAPI is a planned enhancement here.
@Slf4j
@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        log.info("getAllProducts invoked");
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) throws Exception {
        log.info("Adding product with name [{}]", product.getProductName());
         Product result = productService.add(product.getProductName());
         log.info("Added product with name [{}] successfully", result.getProductName());
    }

    // Generic exception handler for demonstration purposes. Should be replaced with specific handlers.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        log.error("Exception occurred: ", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}