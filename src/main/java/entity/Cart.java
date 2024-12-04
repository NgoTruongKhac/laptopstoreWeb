package entity;

public class Cart {
	
	private String cartId;
	private int userId;
	private int productId;
	private String productType;
	private int quantity;
	public Cart(int userId, int  productId, String productType,int quantity) {
		this.userId = userId;
		this.productId = productId;
		this.productType = productType;
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
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
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
