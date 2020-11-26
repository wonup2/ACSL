package Contest2;
/*
Jaemin Choi
Grade 10
STEMPIA
Intermediate 5
Contest 2
*/


import java.util.*;
import java.io.*;

public class c2_Jaemin {
	
	static Scanner in;
	static String a, b;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920C2in.in"));
	
		for(int i = 0; i < 5; i++) {
			try {
				init();
				solve();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	static void solve() {
		while(true) {
			remove();
			if(!shift()) {
				break;
			}
		}
		calculate();
	}

	static void remove() {

		for(int i = 0 ; i < a.length() && i < b.length(); i++) {
			if(a.charAt(i) == b.charAt(i)) {
				a = charRemoveAt(a, i);
				b = charRemoveAt(b, i);
                i--;
			}
		
		}
		
	}

	static boolean shift() {
		for(int i = 0; i < a.length()-1 && i < b.length()-1; i++) {
		if(a.charAt(i) == b.charAt(i + 1)) {
			b = charRemoveAt(b, i);
			return true;
			}
		else if(b.charAt(i) == a.charAt(i+1)) {
			a = charRemoveAt(a, i);
			return true;
			}
		}
		return false;
	}
	

	static void calculate() {
		int total = 0;
		for(int i = 0; i < a.length() && i < b.length(); i++) {
			total += (a.charAt(i) - b.charAt(i));
			
		}
		if(a.length() > b.length()) {
			total += a.length() - b.length();
		}
		else if(b.length() > a.length()) {
			total += b.length() - a.length();
		}
		System.out.println(total);
		
	}

	static void init() {
		a = in.next();
		b = in.next();	
	}

	public static String charRemoveAt(String str, int p) {  
        return str.substring(0, p) + str.substring(p + 1);  
     }  

}
