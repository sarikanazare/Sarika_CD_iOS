package JavaPrograms;

public class OccurenceString {

	static void countstring(String str, char ch) {

		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch1 = str.charAt(i);
			if (ch1 == ch)
				count++;
		}

		System.out.println("The Character is->>" + ch + "  " + count);

	}

	public static void main(String[] args) {
		String str = "bcaaaafgahhajk";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (str.indexOf(ch) == str.lastIndexOf(ch)) {
				System.out.println(ch);
			}
			if (str.indexOf(ch) == i) {
				countstring(str, ch);

			}
		}
	}
}
