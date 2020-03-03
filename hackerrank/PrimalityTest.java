package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PrimalityTest {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		BigInteger i = scanner.nextBigInteger();
		if (i.isProbablePrime(1)) {
			System.out.println("prime");
		} else {
			System.out.println("not prime");
		}
		scanner.close();
	}
}
