package JavaPrograms;

import java.util.Hashtable;

public class HashTableProgram {
	public static void main(String[] args) {
		Hashtable<Integer,String> ht = new Hashtable();
		ht.put(1, "amit");
		ht.put(4, "akash");
		ht.put(9, "minu");
		ht.put(800, "snehal");
		System.out.println("All hashtable values are"+ht);
		String x=ht.get(4);
		System.out.println("The get value is"+x);
	}

}
