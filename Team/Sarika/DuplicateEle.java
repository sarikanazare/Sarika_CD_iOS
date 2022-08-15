package JavaPrograms;

public class DuplicateEle {

	public static void main(String[] args) {
		int numbers[] = { 0, 0, 9, 6, 9, 0, 1, 0 };
		for (int i = 0; i < numbers.length; i++) {
			numbers[numbers[i] % numbers.length] = numbers[numbers[i] % numbers.length] + numbers.length;

		}
		System.out.println("The duplicate elements are->>");
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] >= numbers.length * 2) {
				System.out.println(i + "  ");
			}
		}
	}
}
