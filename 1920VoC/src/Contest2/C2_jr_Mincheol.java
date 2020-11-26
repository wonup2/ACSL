package Contest2;
/*
 * Mincheol Song 9
 * Voice of Calling
 * Junior
 */

import java.util.*;
import java.io.*;

public class C2_jr_Mincheol {

	static Scanner in;
	static String a , b;
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("1920C2jr.in"));
		
		for(int i=0; i<5; i++) {
			try {
				init();
				solve();
			}
			catch(Exception e) {
				System.out.println("Error");
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
		a = removeDP(a);
        b = removeDP(b);
        //System.out.println(a + " " + b);
        
        a = removeVowel(a);
        b = removeVowel(b);
       // System.out.println(a + " " + b);
        
        removeSame();
      
        a = reverse(a);
        b = reverse(b);
        removeSame();
        a = reverse(a);
        b = reverse(b);
       
        System.out.println(ans());
        
	}
	private static String ans() {
		if(a.length()>b.length())
		return b;
		else if(b.length()>a.length())
		return a;
		else {
			if(a.compareTo(b)<0)
				return a;
			else return b;
		}
		
	}

	private static String reverse(String s2) {
		String result  = "";
		for(int i =s2.length()-1; i>=0; i--) {
			result+=s2.charAt(i);
		}
		return result;
	}

	private static void removeSame() {
		for(int i =0; i<a.length() && i<b.length(); i++) {
			char c = a.charAt(i);
			char c1 = b.charAt(i);
			if(c == c1) {
				a = a.substring(0, i) + a.substring(i+1);
				b = b.substring(0, i) + b.substring(i+1);   
                i--;
			}
		}
	}

	private static String removeVowel(String s1) {
		String result = s1.charAt(0)+"";
		for(int i =1; i<s1.length(); i++) {
			char c = s1.charAt(i);
			if(c!='I'&&c!='E'&&c!='A'&&c!='O'&&c!='U')
				result+=s1.charAt(i);
			
		}
		return result;
	}

	private static String removeDP(String s) {
			String result = s.charAt(0)+"";
			for(int i = 0; i<s.length()-1; i++) {
				char a = s.charAt(i);
				char b = s.charAt(i+1);
				if(a!=b) {
					result+=b;
				}
			}
			return result;
	 }

}
