package com.codewitharjun.fullstackecommerce.service;

import com.codewitharjun.fullstackecommerce.model.Product;
import com.codewitharjun.fullstackecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        product.setCreatedTime(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
