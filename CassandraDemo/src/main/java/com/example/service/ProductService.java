package com.example.service;

import java.util.List;

import com.example.model.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	public Product saveProdduct(Product product);

	public void deleteProduct(int id) throws Exception;

	public Product updateProduct(Product product, int id) throws Exception;

	public int getNextId();

}
