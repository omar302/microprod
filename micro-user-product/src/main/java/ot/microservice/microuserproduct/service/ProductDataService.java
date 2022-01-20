package ot.microservice.microuserproduct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import ot.microservice.microuserproduct.data.Product;
import ot.microservice.microuserproduct.data.ProductData;
import ot.microservice.microuserproduct.entity.UserProduct;

@Service
public class ProductDataService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackProductData")
	public ProductData getProductData(UserProduct up) {
		Product product = 
				restTemplate.getForObject(
						"http://micro-product/products/" + up.getProductId(), Product.class);
		return new ProductData(product, up.getQuantity());
	}
	
	public ProductData getFallbackProductData(UserProduct up) {
		return new ProductData(new Product(up.getProductId(), "not found", "not found"), up.getQuantity());
	}

}
