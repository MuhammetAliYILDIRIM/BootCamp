package homework3;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Basket {
	private List<Item> myBasket;

	public Basket() {
		myBasket = new ArrayList<>();
	}

	public void addItem(String name, double price, Type itemKind, int count) {
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
		NumberFormat fm = NumberFormat.getCurrencyInstance();
		double totalPrice = 0.;
		
		System.out.println("----------------BILL-------------------");
		
		for (Item i : myBasket) {
			System.out.println(i.getItemKind() + "\t\t" + i.getName() + "\t\t" + fm.format(i.getPrice()));
			totalPrice += i.getPrice();
		}
		
		Map<String, List<Item>> giftList = myBasket.stream().collect(Collectors.groupingBy(Item::getName));
		giftList.forEach((key, value) -> {
			if (value.size() > 2) {
				for (int i = 1; i <= value.size() / 3; i++) {

					System.out.println(value.get(0).getItemKind() + "\t\t" + key + "\t\t" + "Gifted Item");
				}
			}

		});

		System.out.println("Total Price :" + fm.format(totalPrice));
	}

}
