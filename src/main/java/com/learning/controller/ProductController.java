package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.enums.Status;
import com.learning.models.ProductRequest;
import com.learning.models.ProductResponse;
import com.learning.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ProductResponse postOrder(@RequestBody ProductRequest productRequest) {
		return productService.createProduct(productRequest);
	}
	
	@GetMapping("/{id}")
	public ProductResponse getProductById(@PathVariable Long id) {
		return productService.findProductById(id);
	}
	@PutMapping("/{id}")
	public ProductResponse updateProductById(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
		return productService.updateProduct(id, productRequest);
	}
	@DeleteMapping("/{id}")
	public Status deleteById(@PathVariable Long id) {
		return productService.deleteById(id);
	}
}
