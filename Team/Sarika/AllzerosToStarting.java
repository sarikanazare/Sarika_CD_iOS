//String str="32400121200";
//•Output should be: 00003241212
//(all zeroes should be in starting)String str="32400121200";
package JavaPrograms;

import java.util.Scanner;

public class AllzerosToStarting {
public static void main(String[] args) {
	
	   String str="32400121200";

	    String s1=    str.replace("0", "");
	    System.out.println(s1);
	    String s2=str.replaceAll("[^0]", "");
	    System.out.println(s2);

	    System.out.println(s2+s1);

	    }
	
}
