package Programs;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class RemoveDuplicateEle {
	public static void removeDuplicates(int[] a)
    {
        HashSet<Integer> set
            = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++)
            set.add(a[i]);
        System.out.print(set);
    }
    public static void main(String[] args)
    {
        int a[] = {10,10,20,2,20,30,30};
        removeDuplicates(a);
    }

}
