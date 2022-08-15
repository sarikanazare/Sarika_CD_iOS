package JavaPrograms;

public class FrequencyOfWord {

	public static void checkFrequency(String str, String s1) {
	 int count = 0;
     System.out.println(str);
     String s[] = str.split(" ");
     for (int i = 0; i < s.length; i++) {

         if (s[i].contains(s1)) {
             count++;

         }

     }
     System.out.println("Occurrence of good word is " + count);
	}

 public static void main(String[] args) {
     checkFrequency("Today is monday and today is wonderful day","day");

}
}