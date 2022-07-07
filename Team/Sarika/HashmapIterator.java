package Programs;

import java.util.HashMap;

public class HashmapIterator {
	Character[] number = { 'a', 'a', 'b', 'f', 'l', 'n', 'a' };
	//a-3 b-1, f-1, i-1, n-1, 
			// a-3, b-1, f-1, l-1,n-1 key-Charater value- Inetger
			HashMap<Character, Integer> map = new HashMap();{

			for (int i = 0; i < number.length; i++) {
				if (map.containsKey(number[i])) {// a
					Integer value = map.get(number[i]);// 1
					map.put(number[i], ++value);
				} else
					map.put(number[i], 1);

			}
			System.out.println(map);
}
}