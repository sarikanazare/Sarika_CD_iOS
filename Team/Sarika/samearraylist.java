package JavaPrograms;

import java.util.ArrayList;

public class samearraylist {
	public static void main(String[] args) {

		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(2);
		a1.add(3);
		a1.add(4);
		a1.add(5);
		a1.add(6);
		a1.add(7);

		System.out.println("Arraylist is" + a1);

		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(2);
		a2.add(7);
		a2.add(6);
		a2.add(4);
		a2.add(3);
		a2.add(5);
		System.out.println("Arraylist 2 is" + a2);

		if (a1.containsAll(a2) == true) {
			System.out.println("All elements are same ");
		} else {
			System.out.println("All elements are NOT same ");
		}

		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(2);
		a3.add(3);
		a3.add(4);
		a3.add(5);
		a3.add(6);
		a3.add(7);
		a3.add(8);

		System.out.println("Then length of a3 is" + a3.size());
		ArrayList<Integer> a4 = new ArrayList<Integer>();
		a4.add(2);
		a4.add(7);
		a4.add(6);
		a4.add(4);
		a4.add(3);
		a4.add(5);

		System.out.println("Then length of a4 is" + a4.size());

		if (a3.equals(a4) == true) {
			System.out.println("array list are the same");
		} else {
			System.out.println("array list are NOT the same");
		}
	}
}
