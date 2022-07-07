package Programs;

import java.util.Scanner;

public class first {
	public static void main (String args[]){
	int i;
	String str = "my name is sarika";
	String[] newstr=str.split("\\S");
	StringBuilder sb = new StringBuilder();
	int leng = newstr.length;
	
	for (i=leng-1;i>=0;i--){
		sb.append(newstr[0]);
		sb.append(" ");
		System.out.println("reverse string is "+sb);

	}
}
}