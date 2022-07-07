package Programs;

import java.util.ArrayList;

public class FindDigit {
	 public static void main (String[] args)
	    {
	        char c = 0;
	        String str = "there are 23 tree in graden number 233343";
	        for( int i=0; i<str.length(); i++)
	        {
	        c = str.charAt(i);
	         
	        if(Character.isDigit(c))
	        {
	            System.out.print(c);
	        }      
	        }
	      
	        ArrayList<Integer> a1 = new ArrayList<Integer>();
	        a1.add(10);
	        a1.add(3200);
	        a1.add(200);
	        a1.add(300);
	        a1.size();
	        for (int i=0;i<a1.size();i++){
	        int bb=a1.get(i);
	        System.out.println("index is..."+bb);
	        
	        }
	    }  
}
