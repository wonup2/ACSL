//1819 contest2 
import java.util.*;

public class C2_IN_Diff {

	static Scanner in;
	static String a, b;
	static TreeSet<Character> set;
	static boolean first = true, letter[][];
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		for(int i=0; i<5; i++) {
			init();
			solve();
		}
	}

	static void init() {
		a = in.next();
		b = in.next();
		set = new TreeSet<Character>();
		letter = new boolean[26][26];
	}
	
	static void solve() {
		
		common(a, b, 0); 
		common(b, a, 1);		
		a = new StringBuilder(a).reverse().toString();
		b = new StringBuilder(b).reverse().toString();
		common(a, b, 2);		
		common(b, a, 3);	
		
		makeSet();
		
		for(char c: set) System.out.print(c);
		System.out.println();
	}
	
	static void makeSet() {
		
		for(int i=0; i<26; i++) {
			int cnt=0;
			for(int j=0; j<4; j++) 
				if(letter[j][i]) cnt++;
			
			if(cnt==4) set.add((char)(i+'a'));
		}		
	}
	
	static void common(String a, String b, int r) {
		
		int idx = 0;
		
		for(int i=0; i<a.length(); i++) {
			char c = a.charAt(i);
			if(b.indexOf(c, idx)>=0) {
				letter[r][c-'a']= true;
				idx = b.indexOf(c, idx)+1;
			}
		}			
	}
}

/*

abcddef vdfaddwf 
friends afraid
delicious indiginous
shalom saaalaaam
happy shipshape


OUTPUT
1. df
2. dfir
3. iosu
4. ams
5. hp

*/