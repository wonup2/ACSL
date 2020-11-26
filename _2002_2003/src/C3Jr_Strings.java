import java.util.*;
import java.io.*;

public class C3Jr_Strings {

	static Scanner in;
	static String word[], s;
	
	public static void main(String[] args) throws IOException {
		init();
		solve();
		in.close();
	}

	static void init() throws IOException {
		in = new Scanner(new File("c3jr.in"));
		s = in.nextLine();
		//System.out.println(s);
		
		word = s.split(" ");		
		//System.out.println(Arrays.toString(word));
	}
	
	static void solve() {
		//1. 
		System.out.println(word.length);
		
		//2.
		int max = 0;
		for(int i=0; i<word.length; i++) {
			max = Math.max(word[i].length(), max);
		}
		
		//System.out.println(max);
		for(int i=0; i<word.length; i++) {
			if(word[i].length() == max)
				System.out.println(word[i]);
		}
		
		//3
		HashSet<Character> set = new HashSet<Character>();
		
		s = s.replace(" ","");
		
		//System.out.println(s);
		for(int i=0; i<s.length(); i++) {
			set.add(s.charAt(i));
		}
		System.out.println(set.size());		
		
		//4
		HashMap<Character, Integer> m = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) {
			char key = s.charAt(i);
			if(!m.containsKey(key)) m.put(key, 1);
			else m.put(key, m.get(key)+1);
		}
		
		max = 0;
		for(char key: m.keySet()) {
			int val = m.get(key);
			max = Math.max(max, val);
		}
		
		for(char key: m.keySet()) {
			int val = m.get(key);
			if(val==max) System.out.println(key);
		}
		
		//5 --- map
		
		HashMap<String, Integer> m2 = new HashMap<String, Integer>();
		
		for(int i=0; i<word.length; i++) {
			
			String key = word[i];
			
			if(!m2.containsKey(key)) m2.put(key, 1);
			else m2.put(key, m2.get(key)+1);
			
		}
		//System.out.println(m2);
		max = 0;
		for(String key: m2.keySet()) {
			if(key.equals("THE")) continue;
			int val = m2.get(key);
			max = Math.max(max, val);
		}
		for(String key: m2.keySet()) {
			int val = m2.get(key);
			if(max==val) System.out.println(key);
		}
	}
	
}
