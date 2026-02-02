package com.sgelman.backend.controller;

import com.sgelman.backend.model.Product;
import com.sgelman.backend.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Test
    void testGetAllProductsNoneExist() throws Exception {
        when(productService.getAllProducts()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/product/all"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));

        verify(productService).getAllProducts();
    }

    @Test
    void testGetAllProductsWithProducts() throws Exception {
        when(productService.getAllProducts()).thenReturn(
                List.of(new Product(1L, "Product1"),
                        new Product(2L, "Product2")));

        mockMvc.perform(get("/product/all"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"productId\":1,\"productName\":\"Product1\"},{\"productId\":2,\"productName\":\"Product2\"}]"));

        verify(productService).getAllProducts();
    }

    @Test
    void testAddProductSuccessfully() throws Exception {
        Product product = new Product(3L, "NewProduct");
        when (productService.add("NewProduct")).thenReturn(product);

        ObjectMapper mapper = new ObjectMapper();
        String productJson = mapper.writeValueAsString(product);

        mockMvc.perform(post("/product/add")
                        .contentType("application/json")
                        .content(productJson)
                )
                .andExpect(status().isCreated());

        verify(productService).add("NewProduct");
    }

    @Test
    void testAddProductFails() throws Exception {
        Product product = new Product(3L, "NewProduct");
        when (productService.add("NewProduct")).thenThrow(new Exception("Duplicate product"));

        ObjectMapper mapper = new ObjectMapper();
        String productJson = mapper.writeValueAsString(product);

        mockMvc.perform(post("/product/add")
                        .contentType("application/json")
                        .content(productJson)
                )
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Duplicate product"));

        verify(productService).add("NewProduct");
    }
}