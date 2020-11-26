package Contest2;
/*
 * Name: Roy Park
 * Grade: 9th Grade
 * Team: ABCobot
 * Division: Junior 5
 * Contest 2
 */
import java.util.*;
import java.io.*;
public class JR_String_Differences_Roy {
	static Scanner in;
	static String s1;
	static String s2;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920c2jr.in"));
		try {
			for(int i = 0;i<5;i++) {
				init();
				solve();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	public static void init() {
		s1 = in.next();
		s2 = in.next();
	}
	public static void solve() {
		s1 = removeD(s1); 
		s2 = removeD(s2);
		s1 = removeVowel(s1);
		s2 = removeVowel(s2);
		leftR();
		rightL();
		ans();
	}
	public static String removeD(String s){
	    String sub = ""+s.charAt(0);
	        for(int i = 1; i < s.length(); i++) {
	          char a = sub.charAt(sub.length()-1);
	          char b = s.charAt(i);
	          if(isConsonant(b)) {
	        	  if(a!=b) sub+=b;
	          }
	          else {
	        	  sub+=b;
	          }
	        }

	    return sub;
	}
	public static String removeVowel(String s) {
		String sub = ""+s.charAt(0);
		for(int i = 1;i<s.length();i++) {
			char b = s.charAt(i);
			if(b!= 'A'&& b!= 'E'&& b!= 'I'&& b!= 'O'&& b!= 'U') {
				sub+=s.charAt(i);
			}
		}
		return sub;
	}
	public static String reverse(String s) {
		String sub = "";
		for(int i = s.length()-1;i>=0;i--) {
			sub+=s.charAt(i);
		}
		return sub;
	}
	public static void leftR() {
		String sub1 = "";
		String sub2 = "";
		int len = Math.min(s1.length(), s2.length());
		for(int i = 0;i<len;i++) {
			if(s1.charAt(i)!=s2.charAt(i)) {
				sub1+=s1.charAt(i);
				sub2+=s2.charAt(i);
			}
		}
		s1 = sub1 + s1.substring(len);
		s2 = sub2 + s2.substring(len);
	}
	public static void rightL() {
		String sub1 = "";
		String sub2 = "";
		String e1, e2;
		int len = Math.min(s1.length(), s2.length());
		e1 = reverse(s1);
		e2 = reverse(s2);
		for(int i = 0;i<len;i++) {
			if(e1.charAt(i)!=e2.charAt(i)) {
				sub1+=e1.charAt(i);
				sub2+=e2.charAt(i);
			}
		}
		s1 = sub1 + e1.substring(len);
		s2 = sub2 + e2.substring(len);
		s1 = reverse(s1);
		s2 = reverse(s2);
	}
	public static void ans() {
		if(s1.length()==s2.length()) {
			if(s1.compareTo(s2)<0) System.out.println(s1);
			else System.out.println(s2);
		}
		else if(s1.length()>s2.length()) System.out.println(s2);
		else if(s1.length()<s2.length()) System.out.println(s1);
	}
	public static boolean isConsonant(char a) {
		if(a== 'A'|| a== 'E'|| a== 'I' || a== 'O'|| a== 'U') return false;
		else return true;
	}
}
