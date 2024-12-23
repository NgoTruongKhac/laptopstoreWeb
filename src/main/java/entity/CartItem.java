package entity;

public class CartItem {
	
	private int cartId;
	private int userId;
	private int productId;
	private int quantity;
	private String name;
	private String image;
	private int price;
	private String type;

	public CartItem(int cartId,int userId, int productId, int quantity, String name, String image, int price) {
		this.cartId=cartId;
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.name = name;
		this.image = image;
		this.price = price;
	}
	
	public CartItem(int productId, int quantity, String name, String image, int price) {
		this.productId = productId;
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
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "CartItem [userId=" + userId + ", productId=" + productId + ", productType=" 
				+ ", quantity=" + quantity + ", name=" + name + ", image=" + image + ", price=" + price + "]";
	}
	
	
	
	
	

}
