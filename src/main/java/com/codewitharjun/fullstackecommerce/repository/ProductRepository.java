package com.codewitharjun.fullstackecommerce.repository;

import com.codewitharjun.fullstackecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {


}
