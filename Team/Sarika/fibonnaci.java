package Programs;

import java.util.Scanner;

public class fibonnaci {
	public static void main(String args[]) {
		int a = 0, b = 1, i, c;
		Scanner s1 = new Scanner(System.in);

		System.out.println("how many terms u want");
		int n = s1.nextInt();
		System.out.print(a + " " + b);

		for (i = 1; i <= n; i++) {
			c = a + b;
			System.out.print(" " + c);
			a = b;
			b = c;
		}

	}
}

