package JavaPrograms;

import java.util.Vector;

public class VectorProgram {

	public static void main(String[] args) {
		Vector<Integer> v=new Vector(4,2);
		v.add(2);
		v.add(1, 20);
		v.size();
		System.out.println("size of vector"+v);
		v.capacity();
		System.out.println("capacity of vector"+v);
	}
}
