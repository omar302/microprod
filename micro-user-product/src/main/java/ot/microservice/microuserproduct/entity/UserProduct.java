package ot.microservice.microuserproduct.entity;

public class UserProduct {
	
	private Integer userId;
	private Integer productId;
	private Integer quantity;
	
	protected UserProduct() {}

	public UserProduct(Integer userId, Integer productId, Integer quantity) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
