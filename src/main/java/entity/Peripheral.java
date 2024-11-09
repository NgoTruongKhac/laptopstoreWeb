package entity;

public class Peripheral {

	private int peripheralId;
	private String name;
	private String description;
	private String image;
	private int price;
	private String brand;
	private String category;

	public Peripheral(String name, String description, String image, int price, String brand, String category) {
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.brand = brand;
		this.category = category;
	}

	public int getPeripheralId() {
		return peripheralId;
	}

	public void setPeripheralId(int peripheralId) {
		this.peripheralId = peripheralId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescripion(String description) {
		this.description = description;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
