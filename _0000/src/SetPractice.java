import java.util.*;


public class SetPractice {

	public static void main(String[] args) {

		HashSet<Integer> s1 = new HashSet<Integer>();
		
		s1.add(1);
		s1.add(2);
		s1.add(10);
		s1.add(11);
		s1.add(23);
		s1.add(1);  //<-- ignore 1 since s1 has 1
		s1.add(2);	//<-- ignore 2
		
		System.out.println(s1);
		System.out.println(s1.size());
		
		System.out.println("Print all values in s1");
				
		for(int n : s1) {			
			System.out.println(n);		
		}
		
		System.out.println("3rd value in s1");
		int cnt = 0;		
		for(int n: s1) {
			cnt++;
			if(cnt==3) System.out.println(n);
		}
		
		//----------------------------------------
		
		TreeSet<Character> s2 = new TreeSet<Character>();
		s2.add('A');
		s2.add('Z');
		s2.add('D');
		
		System.out.println(s2);
		
		for(char c: s2) {
			System.out.print(c+" ");
		}
		System.out.println();
		
		
		//----------------------------------------
		
		LinkedHashSet<String> s3 = new LinkedHashSet<String>();
		s3.add("Stempia");
		s3.add("Hello");
		s3.add("World");
		s3.add("Bye");
	
		
		System.out.println(s3);
	}

}
