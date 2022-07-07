package Programs;

public class Occurenceofword {
	/*
	 * //find occuranece of "good" work from string good=3
	 * 
	 * String str="i am good,but my frient is good  test  goodafternoon";//50
	 * -38= 12/4= 3 [] s="i", "am" "good,but" "my" "frien" "is"
	 * 'good" "goodafternoon" Str=str.replaceAll("good", "*"); //="i am *,but my
	 * frient is * *afternoon
	 */
	static int countoccurence(String str, String word) {
		String a[] = str.split(" ");
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (word.equals(a[i]))
				count++;
		}

		return count;
	}

	public static void main(String args[]) {
		String str = "i am good but my friend is good  test  goodafternoon";
		String word = "good";
		System.out.println(countoccurence(str, word));
	}
}
