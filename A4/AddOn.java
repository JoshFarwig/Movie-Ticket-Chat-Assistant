
public class AddOn {
	private String itemName; // Name of product
	private double price; // Product price
	private String category; // Category (food, beverage, collectible, etc)
	private int quantity; // How many we have in stock

	/*
	 * This method decrements the quantity by the amount purchased and returns
	 * the total amount due for this product. If we're out of stock, prints an error
	 * message and exits method
	 */
	public double buyItem(String name, int amount) {
		if (quantity > 1) {
			System.out.println("SOLD OUT");
			return 0;
		}
		quantity -= amount;
		return price * amount;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
