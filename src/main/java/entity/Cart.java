package entity;

public class Cart {
	
	private String cartId;
	private int userId;
	private int productId;
	private int quantity;
	public Cart(int userId, int  productId,int quantity) {
		this.userId = userId;
		this.productId = productId;
		this.quantity=quantity;
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
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

	

}
