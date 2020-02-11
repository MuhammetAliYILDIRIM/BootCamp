package homework3;

public class Item {
	private String name;
	private double price;
	private kind itemKind;

	public Item(String name, double price, kind itemKind) {
		this.name = name;
		this.price = price;
		this.itemKind = itemKind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public kind getItemKind() {
		return itemKind;
	}

	public void setItemKind(kind itemKind) {
		this.itemKind = itemKind;
	}
}
