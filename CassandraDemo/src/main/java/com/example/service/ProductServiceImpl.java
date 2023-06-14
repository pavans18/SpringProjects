package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product saveProdduct(Product product) {

		int id = getNextId();
		product.setId(id);
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(int id) {

		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("product with id: " + id + " Not present"));

		productRepository.delete(product);

	}

	@Override
	public Product updateProduct(Product product, int id) throws Exception {

		Product productExisting = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("product with id: " + id + " Not present"));

		product.setId(id);

		return productRepository.save(product);
	}

	@Override
	public int getNextId() {

		int maxId = productRepository.findMaxProductId();

		if (maxId == 0) {
			maxId = 1;
		} else {
			maxId = maxId + 1;
		}
		return maxId;
	}

}
