package com.example.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entity.Product;
import com.example.project.error.ResourceNotFoundException;
import com.example.project.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductImpl implements ProductService{

	@Autowired 
	private ProductRepository repo;
	
	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		Product saved = repo.save(product);
		return saved;
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		Optional<Product> exists = repo.findById(product.getId());
		Product p = null;
		
		if(exists.isPresent())
		{ 
			p = repo.save(product);
		}
		else {
			throw new ResourceNotFoundException("Record not found with id : " + product.getId());
		}
		
		return p;
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		repo.delete(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product getProductById(long id) {
		// TODO Auto-generated method stub
		Optional<Product> exists = repo.findById(id);
		Product p = null;
		
		if(exists.isPresent())
		{ 
			p = exists.get();
		}
		else {
			throw new ResourceNotFoundException("Record not found with id : " + id);
		}
		
		return p;
	}

}
