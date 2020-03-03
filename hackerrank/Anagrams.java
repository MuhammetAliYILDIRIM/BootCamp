package hackerrank;

import java.util.Scanner;

public class Anagrams {

	static boolean isAnagram(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		a = a.toUpperCase().trim().replaceAll(" ", "");
		b = b.toUpperCase().trim().replaceAll(" ", "");
		int charOfA[] = new int[26];
		int charOfB[] = new int[26];

		for (int i = 0; i < a.length(); i++) {
			charOfA[a.charAt(i) - 'A']++;
			charOfB[b.charAt(i) - 'A']++;
		}

		for (int i = 0; i < 26; i++) {
			if (charOfA[i] != charOfB[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		boolean ret = isAnagram(a, b);
		System.out.println((ret) ? "Anagrams" : "Not Anagrams");
	}
}
