package entity;

public class CartItem {
	
	private int cartId;
	private int userId;
	private int productId;
	private String productType;
	private int quantity;
	private String name;
	private String image;
	private int price;

	public CartItem(int cartId,int userId, int productId, String productType, int quantity, String name, String image, int price) {
		this.cartId=cartId;
		this.userId = userId;
		this.productId = productId;
		this.productType = productType;
		this.quantity = quantity;
		this.name = name;
		this.image = image;
		this.price = price;
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
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	@Override
	public String toString() {
		return "CartItem [userId=" + userId + ", productId=" + productId + ", productType=" + productType
				+ ", quantity=" + quantity + ", name=" + name + ", image=" + image + ", price=" + price + "]";
	}
	
	
	
	
	

}
