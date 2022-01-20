package ot.microservice.microuserproduct.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ot.microservice.microuserproduct.data.ProductData;
import ot.microservice.microuserproduct.data.User;
import ot.microservice.microuserproduct.data.UserProductData;
import ot.microservice.microuserproduct.entity.UserProduct;
import ot.microservice.microuserproduct.service.ProductDataService;
import ot.microservice.microuserproduct.service.UserService;

@RestController
@RequestMapping("/userproducts")
public class UserProductController {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductDataService productDataService;
	
	@GetMapping("/users/{userId}")
//	@HystrixCommand(fallbackMethod = "getFallbackUserProducts")
	public UserProductData getUserProducts(@PathVariable("userId") Integer userId) {
		
		List<UserProduct> userProductsTable = Arrays.asList(
				new UserProduct(1, 1, 1), 
				new UserProduct(1, 2, 4),
				new UserProduct(1, 3, 2),
				new UserProduct(2, 1, 3),
				new UserProduct(2, 2, 2),
				new UserProduct(2, 3, 2),
				new UserProduct(3, 1, 3),
				new UserProduct(3, 2, 5));
		
		User user = userService.getUser(userId);
		if (user == null)
			return null;
		
		List<ProductData> productDataList = userProductsTable.stream()
				.filter(up -> up.getUserId().equals(userId))
                .map(up -> {
                	return productDataService.getProductData(up); 
                })
                .collect(Collectors.toList());
		
		return new UserProductData(user, productDataList);
	}
	
//	public UserProductData getFallbackUserProducts(@PathVariable("userId") Integer userId) {
//		return new UserProductData(new User(0, "none", "none", "none"), 
//				Arrays.asList(new ProductData(new Product(0, "none", "none"), 0)));
//	}

}
