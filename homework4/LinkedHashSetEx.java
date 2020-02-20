package homework4;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LinkedHashSetEx {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Set<Integer> linkedSet = new LinkedHashSet<>();

		int howManyTimes = Integer.valueOf(scan.nextLine());
		int queriesNumber = 0;
		while (howManyTimes > 0) {
			queriesNumber = Integer.valueOf(scan.nextLine());
			while (queriesNumber > 0) {
				switch (scan.next()) {
				case "a":
					linkedSet.add(scan.nextInt());
					break;
				case "b":
					System.out.print(linkedSet.stream().sorted().collect(Collectors.toList()).toString()
							.replace("[", "").replace("]", "").replace(",", "") + " ");
					break;

				case "c":
					linkedSet.remove(scan.nextInt());
					break;

				case "d":
					if (linkedSet.contains(scan.nextInt())) {
						System.out.print(1 + " ");
					} else {
						System.out.print(-1 + " ");
					}

					break;
				case "e":
					System.out.print(linkedSet.size() + " ");
					break;

				case "f":
					System.out.print(linkedSet.toString().replace("[", "").replace("]", "").replace(",", "") + " ");
					break;

				default:
					System.out.println("Unvalid command");
					break;
				}

				queriesNumber--;
			}
			System.out.println();
			scan.nextLine();
			howManyTimes--;
		}
		scan.close();

	}

}
