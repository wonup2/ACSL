import java.util.*;

public class MapPractice {

	public static void main(String[] args) {

		Map<String, Integer>  m  = new LinkedHashMap<String, Integer>();
		
		m.put("Eric", 100);
		m.put("Jason", 90);
		m.put("Erin", 95);
		m.put("Solomon", 50);
		m.put("Hemosoo", 101);
		m.put("Eric", 90);
		
		for(String key:m.keySet()) {
			System.out.println(key+" : "+ m.get(key));
		}
		
		if(m.containsKey("Lee")) {
			System.out.println("Yes");
		}
		else System.out.println("No");

		System.out.println(m.get("Lee"));

	}

}
