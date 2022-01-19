package ot.microservice.microproduct.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ot.microservice.microproduct.entity.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@GetMapping()
	public List<Product> getProducts() {
		
		return getProductData();
	}
	
	@GetMapping("/{productId}")
	public Product getProducts(@PathVariable("productId") Integer productId) {
		
		Optional<Product> opproduct = getProductData().stream()
				.filter(p -> p.getId().equals(productId))
				.findFirst();
		
		if (opproduct.isPresent()) {
			return opproduct.get();
		}
		return null;
	}

	private List<Product> getProductData() {
		List<Product> products = Arrays.asList(
				new Product(1, "Apple", "This is a red apple."), 
				new Product(2, "Banana", "This is a banana."),
				new Product(3, "Orange", "This is an orange."));
				
		return products;
	}
	
}