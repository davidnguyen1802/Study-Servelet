package product.entity;

public class ProductApple {
	private int id;
	private String name_of_product;
	private int quantity;
	private double price;
	
	public ProductApple(int id, String name_of_product, int quantity, double price) {
		this.id = id;
		this.name_of_product = name_of_product;
		this.quantity = quantity;
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName_of_product() {
		return name_of_product;
	}
	public void setName_of_product(String name_of_product) {
		this.name_of_product = name_of_product;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
