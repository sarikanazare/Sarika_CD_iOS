package Programs;

public class SumofDgit2 {
	public static void main(String[] args) {
		String str = "My age 13 , after 5 years i become 18 years old 2 my";
		String temp = "";
		int sum = 0;
		for (int i = 0; i <str.length(); i++) {
		Boolean flag = Character.isDigit(str.charAt(i));
		if (flag) {
		temp = temp + str.charAt(i);
		System.out.println(temp);
		}
		else if(!temp.isEmpty()){
		sum = sum + Integer.parseInt(temp);
		temp="";
		}
		}
		if(temp!=""){
		sum = sum + Integer.parseInt(temp);
		}
		System.out.println("Addition: " + sum);
		}
		}

