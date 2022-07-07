
package Programs;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeSet;

public class Collectionset {

	public static void main(String[] args) {
		ArrayList hs=new ArrayList();
		hs.add(2);
		hs.add(8);
		hs.add(10);
		hs.add(2);
		ListIterator li=hs.listIterator();
	
		while(li.hasPrevious())
		{
			System.out.println("-->"+li.previous());
		}
		
	
		
	}
}
