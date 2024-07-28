package com.productService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.productService.domain.Product;
import com.productService.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductRepository productRepository;
	
	@PostMapping("/saveProduct")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody Product product) {
		productRepository.save(product);
		
	}
	
	@GetMapping("/getAllProduct")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> getAllProducts() {
		return productRepository.findAll();
		
	}
}
