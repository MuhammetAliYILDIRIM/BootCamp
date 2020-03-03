package hackerrank;

import java.io.*;
import java.util.*;

public class StringReverse {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String A = sc.next();
		StringBuffer B = new StringBuffer(A);

		if (A.equals(B.reverse().toString())) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}
}