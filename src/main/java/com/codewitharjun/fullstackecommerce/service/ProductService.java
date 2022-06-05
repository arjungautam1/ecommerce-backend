package com.codewitharjun.fullstackecommerce.service;

import com.codewitharjun.fullstackecommerce.model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    void deleteProduct(Long id);

    List<Product> findAllProducts();
}
