import java.util.*;

public class MapPractice {

	public static void main(String[] args) {
		
		HashMap <String, Integer> m1 = new HashMap<String, Integer>();		
		m1.put("Jaeshin", 200);
		m1.put("Tom", 100);		
		m1.put("Amy", 95);
		m1.put("David", 95);
		m1.put("Jaeshin", 100);
		System.out.println(m1);		
		
		TreeMap <String, Integer> m2 = new TreeMap<String, Integer>();
		m2.put("Jaeshin", 200);
		m2.put("Tom", 100);		
		m2.put("Amy", 95);
		m2.put("David", 95);
		
		System.out.println(m2);
		
		LinkedHashMap <String, Integer> m3 = new LinkedHashMap<String, Integer>();
		m3.put("Jaeshin", 200);
		m3.put("Tom", 100);		
		m3.put("Amy", 95);
		m3.put("David", 95);
		m3.put("David", 195);
		
		System.out.println(m3.get("David"));

		for(String key:m3.keySet()) {
			System.out.println(key +" : "+m3.get(key));
		}

		if(m3.containsKey("Tom")) System.out.println("yes");
		
		m3.remove("Tom");
		System.out.println(m3);
	}

}
