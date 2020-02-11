package homework3;

public class RunShopping {

	public static void main(String[] args) {

		Basket myShopping = new Basket();

		myShopping.addItem("bread", 1.0, Type.GROCERY, 3);

		myShopping.bill();

		myShopping.deleteItem("bread", 2);
		
		myShopping.addItem("chocolate", 2.3, Type.GROCERY, 8);
		
		myShopping.addItem("Coat", 200, Type.CLOTHING, 1);

		myShopping.bill();
		
		myShopping.deleteItem("chocolate", 6);
		
		myShopping.bill();

	}

}
