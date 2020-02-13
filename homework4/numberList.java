package homework4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class numberList {
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			List<Integer> numbers =new ArrayList<Integer>();
			System.out.println("If you quit program enter -1");
			while(true) {
				try {
					System.out.println("Enter a number ");
				numbers.add(Integer.parseInt(scan.nextLine()));
				if((numbers.get(numbers.size()-1)==-1)) {
					break;
				}
				System.out.println(numbers.toString());
			
				} catch (InputMismatchException e) {
					System.out.println("You must enter a Integer");
				}
				
			}
		}
}
