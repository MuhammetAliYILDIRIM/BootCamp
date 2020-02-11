package homework3;

public class RunShopping {

	public static void main(String[] args) {

		Basket myShopping = new Basket();

		myShopping.addItem("bread", 1.0, kind.GROCERY, 3);

		myShopping.bill();

		myShopping.deleteItem("bread", 2);

		myShopping.bill();

	}

}
