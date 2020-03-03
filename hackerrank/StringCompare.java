package hackerrank;
import java.lang.ClassNotFoundException;
import java.util.Scanner;

public class StringCompare {

	public static String getSmallestAndLargest(String s, int k) {

		String smallest = s.substring(0, k);
		String largest = s.substring(0, k);

		for (int i = 1; i <= s.length() - k; i++) {
			if (largest.compareTo(s.substring(i, i + k)) < 0) {
				largest = s.substring(i, i + k);
			}
			if (smallest.compareTo(s.substring(i, i + k)) > 0) {
				smallest = s.substring(i, i + k);
			}
		}

		return smallest + "\n" + largest;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int k = scan.nextInt();
		scan.close();

		System.out.println(getSmallestAndLargest(s, k));
	}
}