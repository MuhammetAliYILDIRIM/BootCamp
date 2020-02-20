package homework4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class NumberListProgram {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> numbers = new ArrayList<Integer>();
		System.out.println("Enter 10 numbers");
		Integer number;
		for (int i = 0; i < 10; i++) {
			try {
				System.out.print("\nEnter " + (i + 1) + ".nd number ");
				number = Integer.parseInt(scan.nextLine());

				if (numbers.contains(number)) {
					System.out.println("the number has  aldready been in the list");
					i = i - 1;
					continue;
				}
				numbers.add(number);
				System.out.println(numbers.toString());

			} catch (NumberFormatException e) {
				i = i - 1;
				System.err.println("You must enter a Integer");

			}

		}
		Iterator<Integer> iterator = numbers.iterator();
		while (iterator.hasNext()) {
			if (iterator.next() % 2 == 1) {
				iterator.remove();
			}
		}

		System.out.println(numbers.toString());
		scan.close();
	}
}
