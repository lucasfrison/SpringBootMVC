package com.teste.exemplo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.teste.exemplo.model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository; 

	public List<Product> getAll() {
		return ProductRepository;
	}
}
