import java.util.*;
import java.io.*;

public class C2_Junior {

	static Scanner in;
	static String a, b;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920c2jr.in"));
		for(int i=0; i<5; i++) {
			try {			
				init();
				solve();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		in.close();			
	}

	static void init() {
		a = in.next();
		b = in.next();
	}
	
	static void solve() {
		//step 1
		a = removeDouble(a);
		b = removeDouble(b);
		
		//step 2
		removeSameLocationSameCharacter();
		
		//step 3
		a = reverse(a);
		b = reverse(b);
		removeSameLocationSameCharacter();
		a = reverse(a);
		b = reverse(b);
		
		//print output
		if(a.length()<b.length()) System.out.println(a);
		else if(a.length()==b.length()) {
			if(a.compareTo(b)<0) System.out.println(a);
			else System.out.println(b);
		}
		else System.out.println(b);
	}
	
	static String removeDouble(String a) { 
		String ret = a.charAt(0)+"";
		for(int i=1; i<a.length(); i++) {
			char c = a.charAt(i); 
			if(!isVowel(c) && c!=a.charAt(i-1)) ret+=c;
		}
		return ret;
	}
	
	static void removeSameLocationSameCharacter() {
		int len = Math.min(a.length(), b.length());
		int r = 0;
		for(int i=0; i<len-r; i++) {
			if(a.charAt(i)==b.charAt(i)) {
				a=a.substring(0,i)+a.substring(i+1);
				b=b.substring(0,i)+b.substring(i+1);
				r++;
				i--;
			}
		}
	}
	
	static boolean isVowel(char c) {
		return c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
	}
	
	static String reverse(String s) {
		return new StringBuilder().append(s).reverse().toString();
	}
}
