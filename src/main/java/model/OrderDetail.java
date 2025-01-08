package model;

public class OrderDetail {
	
	private int orderId;
	private int productId;
	private String name;
	private String image;
	private int price;
	private int quantity;
	private String type; 
	public OrderDetail(int orderId, int productId, String name, String image, int price, int quantity,String type) {
		this.orderId = orderId;
		this.productId = productId;
		this.name = name;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
		this.type=type;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "OrderDetail [orderId=" + orderId + ", productId=" + productId + ", name=" + name + ", image=" + image
				+ ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
	

}
