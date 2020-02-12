package homework3;

public class RunShopping {

	public static void main(String[] args) {

		Basket myShopping = new Basket();
		Item bread = new Item("Bread", 1., Type.GROCERY);
		Item milk = new Item("Milk",1.4,Type.GROCERY);
		Item kebab = new Item("Kebab",7.5,Type.FASTFOOD);
		Item coat = new Item("Coat", 120.5, Type.CLOTHING);
		
		myShopping.addItem(bread, 3);
		myShopping.addItem(milk, 2);
		myShopping.addItem(kebab, 4);

		myShopping.bill();
		
		myShopping.deleteItem(bread, 4);
		
		myShopping.deleteItem(bread, 1);
		
		myShopping.deleteItem(kebab, 1);
		
		myShopping.bill();
		
		myShopping.deleteItem(kebab, -12);
		
		myShopping.deleteItem(coat,1);
	


	}

}
