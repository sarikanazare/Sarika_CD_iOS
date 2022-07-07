package Programs;

public class Occurence {
	public static int count(String s, char c) {
		int op = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c)
				op++;
		}
		//System.out.println("occurence is"+op);
		return op;
	}

	public static void main(String args[]) {
		String str = "there are 23 tree in graden number 2343";
		char c = '4';
		System.out.println(count(str, c));
	}
}
