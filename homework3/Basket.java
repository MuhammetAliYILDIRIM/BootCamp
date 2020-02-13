package homework3;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Basket {

	private List<Item> myBasket;
	private Map<Item, Long> groupedList;

	public Basket() {
		myBasket = new ArrayList<>();
	}

	public void addItem(Item newItem, int count) {
		if (count < 0) {
			System.out.println("invalid cost");
		} else {

			for (int i = 1; i <= count; i++) {
				myBasket.add(newItem);
			}
		}
		groupByList();
	}

	public void deleteItem(Item deleteItem, int numberOfDelete) {
		if (numberOfDelete < 0) {
			System.out.println("Number of delete cannot be negative");

		} else {
			if (myBasket.contains(deleteItem)) {
				if (groupedList.get(deleteItem) < numberOfDelete) {
					System.out.println("Invalid delete number");
				} else {
					for (int i = 1; i <= numberOfDelete; i++) {
						myBasket.remove(deleteItem);
					}
				}

			} else {
				System.out.println("Item cannot be founded!");
			}
		}
		groupByList();
	}

	public void groupByList() {
		groupedList = myBasket.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	}

	public void bill() {
		NumberFormat fm = NumberFormat.getCurrencyInstance();
		double totalPrice = 0.;

		System.out.println("----------------------BILL--------------------------");

		for (Item i : myBasket) {

			System.out.printf("%-20s%-20s%-20s\n", i.getItemKind().toString(), i.getName(), fm.format(i.getPrice()));

			totalPrice += i.getPrice();
		}
		groupedList.forEach((key, value) -> {
			if (value >= 3) {
				for (int i = 1; i <= value / 3; i++) {
					System.out.printf("%-20s%-20s%-20s\n", key.getItemKind().toString(), key.getName(), "Gifted Item");
				}
			}
		});
		System.out.println("----------------------------------------------------");
		System.out.println("Total Price :" + fm.format(totalPrice));
		System.out.println("----------------------------------------------------");
	}

}
