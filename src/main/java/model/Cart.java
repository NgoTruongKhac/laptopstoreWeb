package model;

public class Cart {
	
	private int cartId;
	private int userId;
	private int productId;
	private int quantity;
	
	public Cart(int userId, int  productId,int quantity) {
		this.userId = userId;
		this.productId = productId;
		this.quantity=quantity;
	}
	public Cart(int cartId, int userId, int  productId,int quantity) {
		this.cartId = cartId;
		this.userId=userId;
		this.productId = productId;
		this.quantity=quantity;
	}

	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", productId=" + productId + ", quantity=" + quantity
				+ "]";
	}

	

}