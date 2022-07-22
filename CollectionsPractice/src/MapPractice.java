import java.util.*;

public class MapPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(10, "aaa");
		hm.put(2, "bbb");
		hm.put(300, "ccc");
		hm.put(23, "ddd");
		
		System.out.println(hm.get(10));
		
		System.out.println(hm);
		
		
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		
		tm.put(10, "aaa");
		tm.put(2, "bbb");
		tm.put(300, "ccc");
		tm.put(23, "ddd");
		
		System.out.println(tm);

		
		LinkedHashMap<Integer, String> lm = new LinkedHashMap<Integer, String>();
		lm.put(10, "aaa");
		lm.put(2, "bbb");
		lm.put(300, "ccc");
		lm.put(23, "ddd");
		lm.put(10, "zzz");
		
		System.out.println(lm);

		for(int key:lm.keySet()) {
			System.out.println(key +" : " + lm.get(key));
		}
		
	}

}
