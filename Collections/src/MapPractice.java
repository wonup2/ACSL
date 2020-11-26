import java.util.*;
public class MapPractice {

	public static void main(String[] args) {
		//Map<Key, Value>
		Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();
		
		m1.put(10, 3);
		m1.put(30, 100);
		m1.put(10, 20);
		m1.put(25, 9);
		
		System.out.println(m1);
		
		
		Map<Integer, Integer> m2 = new TreeMap<Integer, Integer>();
		
		m2.put(10, 3);
		m2.put(30, 100);
		m2.put(10, 20);
		m2.put(25, 9);
		
		System.out.println(m2);
		
		Map<Integer, Integer> m3 = new LinkedHashMap<Integer, Integer>();
		
		m3.put(10, 3);
		m3.put(30, 100);
		m3.put(105, 20);
		m3.put(25, 9);
		
		System.out.println(m3);
		
		//methods
		System.out.println(m3.size());
		System.out.println(m3.get(25));
		System.out.println(m3.keySet());
		System.out.println(m3.values());
		System.out.println(m3.containsKey(25));
		System.out.println(m3.containsValue(25));
		System.out.println(m3.remove(25));
		
		for(int key:m3.keySet()) {
			System.out.println(key+":"+m3.get(key));
		}	
		
	}
}
