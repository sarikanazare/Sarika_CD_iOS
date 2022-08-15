package JavaPrograms;

import java.util.Scanner;

public class StringPalindrome {

	static boolean isPalindrome(String str) {

		int i = 0, j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "geeks";
		String str2 = "RACEcar";

		str = str.toLowerCase();
		str2 = str2.toLowerCase();

		System.out.print("String 1 :");

		if (isPalindrome(str))
			System.out.print("It is a palindrome");
		else
			System.out.print("It is not a palindrome");

		System.out.print("String 2 :");
		if (isPalindrome(str2))
			System.out.print("It is a palindrome");
		else
			System.out.print("It is not a palindrome");
	}
}
