package com.example.ProductController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	ProductRepository productRepository;

	@PostMapping("/saveproduct")
	public String addProduct(@Valid @RequestBody Product product, BindingResult bindingResult) throws Exception {

		if (bindingResult.hasErrors()) {
			throw new ResourceNotFoundException(bindingResult.toString());
		}

		productService.saveProdduct(product);
		return "New Product added Successfully";
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> findById(@PathVariable("id") Integer productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
		return ResponseEntity.ok().body(product);
	}

	@GetMapping("/products")
	public List<Product> getProducts() {

		return productService.getAllProducts();
	}

	@PutMapping("products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product productDetails)
			throws Exception {

		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));

		product.setName(productDetails.getName());
		product.setPrice(productDetails.getPrice());
		product.setDescription(productDetails.getDescription());

		final Product updatedProduct = productService.updateProduct(product, id);
		return ResponseEntity.ok(updatedProduct);

	}

	@DeleteMapping("products/{id}")
	public String deleteProduct(@PathVariable(value = "id") Integer id) throws Exception {

		productService.deleteProduct(id);
		return "Product Deleted Successfully";
	}

}
