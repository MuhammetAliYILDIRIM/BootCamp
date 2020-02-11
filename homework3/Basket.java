package homework3;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	private List<Item> myBasket;

	public Basket() {
		myBasket = new ArrayList<>();
	}

	public void addItem(String name, double price, kind itemKind, int count) {
		if (count < 0) {
			System.out.println("invalid cost");
		} else {

			for (int i = 1; i <= count; i++) {
				myBasket.add(new Item(name, price, itemKind));
			}
		}
	}

	public void deleteItem(String deleteItem, int deleteCount) {
		for (int i = 1; i <= deleteCount; i++) {

			for (Item item : myBasket) {
				if (item.getName().equals(deleteItem)) {
					myBasket.remove(item);
					break;
				}
			}
		}
	}

	public void bill() {
		double totalPrice = 0.;
		for (Item i : myBasket) {
			System.out.println(i.getItemKind() + " " + i.getName() + " " + i.getPrice());
			totalPrice += i.getPrice();
		}

		System.out.println("Total Price :" + totalPrice);
	}

}
