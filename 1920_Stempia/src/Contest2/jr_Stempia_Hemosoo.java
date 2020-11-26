package Contest2;
/*
 * Name: Hemosoo Woo
 * Grade: 9th
 * Team: Stempia
 * Division: Junior 
 * Contest 2
 */
import java.util.*;
import java.io.*;
public class jr_Stempia_Hemosoo {
	static Scanner in;
	static String s1, s2, res1, res2, a1, a2, b1, b2;
	static char hold;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920C2JR.in"));
		try {
			for(int i = 0; i < 5; i++) {
				init();
				solve();
			}
		} catch(Exception e) {
			System.out.println("Error");
		}
	}
	public static void init() {
		s1 = in.next();
		s2 = in.next();
		hold = ' ';
		res1 = "";
		res2 = "";
		a1 = "";
		a2 = "";
		b1 = "";
		b2 = "";
		}
	public static void solve() {
		res1 = Double(s1, s1.length());
		res2 = Double(s2, s2.length());
		res1 = vowels(res1);
		res2 = vowels(res2);
		lR(res1, res2);
		b1 = a1;
		b2 = a2;
		a1 = "";
		a2 = "";
		lR(reverse(b1), reverse(b2));
		if(a1.length() < a2.length()) {
			System.out.println(reverse(a1));
		} else if(a1.length() > a2.length()) {
			System.out.println(reverse(a2));
		}
		else {
			a2 = reverse(a2);
			a1 = reverse(a1);
			for(int i = 0; i < a1.length(); i++) {
				if(a1.charAt(i) > a2.charAt(i)) {
					System.out.println(a2);
					break;
				} else if(a1.charAt(i) < a2.charAt(i)) {
					System.out.println(a1);
					break;
				}
			}
		}
		
	}
	public static String Double(String s, int l) {
		hold = ' ';
		String res = "";
		for(int i = 0; i < l; i++) {
			if(s.charAt(i) != hold) {
				res += s.charAt(i) + "";
			}
			hold = s.charAt(i);
		}
		return res;
	}
	public static String vowels(String s) {
		String a = "";
		a += s.charAt(0);
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U') {
				
			}
			else {
				a += s.charAt(i) + "";
			}
		}
		return a;
	}
	public static void lR(String a, String b) {
		int length = Math.min(a.length(), b.length());
		for(int i = 0; i < length; i++) {
			if(a.charAt(i) != b.charAt(i)) {
				a1 += a.charAt(i) + "";
				a2 += b.charAt(i) + "";
			}
		}
		if(a.length() != length) {
			a1 += a.substring(length);
		} else {
			a2 += b.substring(length);
		}
		
	}
	public static String reverse(String a) {
		String b = "";
		for(int i = a.length()-1; i >= 0; i--) {
			b += a.charAt(i);
		}
		return b;
	}
}
