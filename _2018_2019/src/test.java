import java.util.*;


public class test {

	static Scanner in;
	static String s;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		s = in.nextLine(); //The quick brown fox, named Roxanne, jumped over Bruno, a lazy dog.
		
		//1. The number of different letters. This will be a number from 1 to 26, inclusive.
		
		HashSet<Character> set = new HashSet<Character>();
		
		String temp = s.toLowerCase();
		temp = temp.replaceAll("[^a-z]", "");
		
		for(int i=0; i<temp.length(); i++) {
			
			char c = s.charAt(i);
			set.add(c);
		}
		
		System.out.println(set.size());
		
		//2. The number of vowels. Vowels are the letters a, e, i, o, and u. 
		
		temp = temp.replaceAll("[^aeiou]", "");
		System.out.println(temp.length());
		
		//3. The number of uppercase letters.
		
		temp = s.replaceAll("[^A-Z]", "");
		System.out.println(temp.length());
		
		//4. The number of times that the most frequent letter appears. There is no distinction between
		//lowercase and uppercase letters.
		
		int a[] = new int[26];
		temp = s.toLowerCase();
		temp = temp.replaceAll("[^a-z]", "");
		
		for(int i=0; i<temp.length(); i++) {
			int c = temp.charAt(i) - 'a'; 			
			a[c]++;
		}
		
		int max = 0;
		for(int i=0; i<26; i++) {			
			max = Math.max(a[i], max);
		}
		System.out.println(max);
		
		//5) The longest word in the sentence. If there is a tie, print the one that appears first when sorting
		//these words alphabetically without regard to lowercase and uppercase.

		temp = s.replaceAll("[^a-zA-Z]", " ");
		String b[] = temp.split(" ");
		System.out.println(Arrays.toString(b));
	}

}
