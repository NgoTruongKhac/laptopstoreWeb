package entity;

public class  Product {

	protected int productId;
	protected String name;
	protected String image;
	protected int price;
	protected String type;

	public Product(int productId, String name, String image, int price, String type) {
		this.productId = productId;
		this.name = name;
		this.image = image;
		this.price = price;
		this.type=type;
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
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", image=" + image + ", price=" + price + "]";
	}

}
