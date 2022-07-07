package Programs;

import java.util.Arrays;

public class DiffBetwnNumber {
	public static void main(String[] args) {
		int[] num = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		System.out.println(" Array is: " + Arrays.toString(num));
		int maxval = num[0];
		int min = num[0];
		for (int i = 1; i < num.length; i++) {
			if (num[i] > maxval)
				maxval = num[i];
			else if (num[i] < min)
				min = num[i];
		}
		
		//sarika
		System.out.println("Difference between the largest and smallest araay element is: " + (maxval - min));
	}
}
