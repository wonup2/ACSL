import java.util.*;

public class C2JR_StringStats {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		
		//1
		String temp = s.toLowerCase().replaceAll("[^a-z]", "");		
		Set<Character> c = new HashSet<Character>();
		for(int i=0; i<temp.length(); i++)
			c.add(temp.charAt(i));
		System.out.println(c.size());
		
		//2
		String _2 = temp.replaceAll("[^aeiou]","");
		System.out.println(_2.length());
		
		//3
		String _3 = s.replaceAll("[^A-Z]", "");	
		System.out.println(_3.length());

		//4 
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		for(int i=0; i<temp.length(); i++) {
			char key =  temp.charAt(i);
			if(m.containsKey(key)) {
				m.put(key, m.get(key)+1);
			}
			else m.put(key, 1);
		}
		
		int max=0;
		for(char key:m.keySet()) {
			max = Math.max(max, m.get(key));
		}
		System.out.println(max);
		
		//5
		String[] _5 = s.replaceAll("[^a-zA-Z0-9\\s]", "").split(" ");	
		System.out.println(Arrays.toString(_5));
		
		
	}

}
//The quick brown fox, named Roxanne, jumped over Bruno, a lazy dog.