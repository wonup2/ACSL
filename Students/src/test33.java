
import java.util.*;

public class test33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "AAA");
		hm.put(300, "EEE");
		hm.put(10, "BBB");
		hm.put(21, "CCC");
		hm.put(15, "DDD");		
		System.out.println(hm);
		
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		tm.put(1, "AAA");
		tm.put(300, "EEE");
		tm.put(10, "BBB");
		tm.put(21, "CCC");
		tm.put(15, "DDD");
		System.out.println(tm);
		
		LinkedHashMap<Integer, String> lm = new LinkedHashMap<Integer, String>();
		lm.put(1, "AAA");
		lm.put(300, "EEE");
		lm.put(10, "BBB");
		lm.put(21, "CCC");
		lm.put(15, "DDD");
		System.out.println(lm);
		
		
		HashSet<String> set = new HashSet<String>();
		set.add("Hello");
		set.add("Hello");
		set.add("Hello");
		set.add("World");
		System.out.println(set);


		
	}

}
