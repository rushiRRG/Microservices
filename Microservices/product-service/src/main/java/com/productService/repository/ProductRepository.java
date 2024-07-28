package com.productService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productService.domain.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

}
