package hackerrank;

import java.util.*;

class Loops {
	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			int sum = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k <= j; k++) {
					sum += Math.pow(2, k) * b;
				}
				System.out.print(a+sum + " ");
				sum = 0;
			}
			
		}
		in.close();
	}
}