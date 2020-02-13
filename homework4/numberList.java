package homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class numberList {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> numbers = new ArrayList<Integer>();
		System.out.println("If you enter -1,you quit the program");
		int number;
		while (true) {
			try {
				System.out.println("Enter a number ");
				number = Integer.parseInt(scan.nextLine());
				if (number == -1) {
					break;
				}
				if (numbers.contains(number)) {
					System.out.println("the number has  aldready been in the list");
					continue;
				}
				numbers.add(number);
				System.out.println(numbers.toString());

			} catch (NumberFormatException e) {
				System.err.println("You must enter a Integer");
			}

		}
	}
}
