package model;

public class Dashboard {

	private int quantityUser;
	private int quantityProduct;
	private int quantityOrder;

	public Dashboard(int quantityUser, int quantityProduct, int quantityOrder) {
		this.quantityUser = quantityUser;
		this.quantityProduct = quantityProduct;
		this.quantityOrder = quantityOrder;
	}

	public int getQuantityUser() {
		return quantityUser;
	}

	public void setQuantityUser(int quantityUser) {
		this.quantityUser = quantityUser;
	}

	public int getQuantityProduct() {
		return quantityProduct;
	}

	public void setQuantityProduct(int quantityProduct) {
		this.quantityProduct = quantityProduct;
	}

	public int getQuantityOrder() {
		return quantityOrder;
	}

	public void setQuantityOrder(int quantityOrder) {
		this.quantityOrder = quantityOrder;
	}

}
