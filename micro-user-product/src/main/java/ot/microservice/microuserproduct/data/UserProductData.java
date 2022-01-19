package ot.microservice.microuserproduct.data;

import java.util.List;

public class UserProductData {
	
	private User user;
	private List<ProductData> productData;
	
	protected UserProductData() {}

	public UserProductData(User user, List<ProductData> productData) {
		super();
		this.user = user;
		this.productData = productData;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ProductData> getProductData() {
		return productData;
	}

	public void setProductData(List<ProductData> productData) {
		this.productData = productData;
	}

}
