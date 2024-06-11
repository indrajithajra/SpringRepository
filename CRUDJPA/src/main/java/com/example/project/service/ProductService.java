package com.example.project.service;

import java.util.List;

import com.example.project.entity.Product;

public interface ProductService {
	
	Product createProduct(Product product);
	
	Product updateProduct(Product product);
	
	void deleteProduct(Product product);
	
	List<Product> getAllProduct();
	
	Product getProductById(long id);	

}
