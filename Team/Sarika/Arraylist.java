package JavaPrograms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Arraylist {

	public static void main(String[] args) {
		ArrayList<String> a1= new ArrayList();
		a1.add("sarika");
		a1.add("shitija");
		a1.add("iosteam");
		System.out.println("The array list is"+a1);
		a1.add(0, "minal");
		System.out.println("The array list is"+a1);
		a1.remove(0);
		System.out.println("The array list is"+a1);
		a1.isEmpty();
		
		
		LinkedList<Integer> ss = new LinkedList();
		
			ss.addFirst(1);	
			ss.add(0, 4);
			ss.add(8);
			System.out.println("The linked list is"+ss);
			
			
			HashSet<String> hs = new HashSet();
			hs.add("1");
			hs.add("5");
			hs.add("80");
			hs.add("100");
			hs.add("2");
			System.out.println("HashSet values are"+hs);
			hs.add("090");
			System.out.println("HashSet values after adding new are"+hs);
			
			
			
			TreeSet t = new TreeSet(hs);
			System.out.println("Treeset values are"+t);
			
			
			
			
			
	}
	
	
}
