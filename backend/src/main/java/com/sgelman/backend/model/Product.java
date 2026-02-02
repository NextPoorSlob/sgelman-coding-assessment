package com.sgelman.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products", indexes = {@Index(name = "product_name_inx", columnList = "name", unique = true)})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    // Needed to match existing sequence in the database.
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_gen")
    @SequenceGenerator(name = "product_seq_gen", sequenceName = "products_product_id_seq", allocationSize = 1)
    private Long productId;

    private String productName;

    public Product(String newProduct) {
        this.productId = null;
        this.productName = newProduct;
    }
}
