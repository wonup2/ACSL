package Contest2;
/*
 * Caden Kang 9
 * Voice of Calling
 * Junior
 */


import java.util.*;
import java.io.*;

public class C2JR_StringDifferences_Caden {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("1920C2JR.in"));
		
		for (int i = 0; i < 5; i++) {
			String s1 = in.next();
			String s2 = in.next();
			
			//STEP 1
			s1 = removeDoubleC(s1);
			s2 = removeDoubleC(s2);
			
			//STEP 2
			String s1temp = s1.substring(1);
			String s2temp = s2.substring(1);
			s1 = s1.charAt(0) + s1temp.replaceAll("[AEIOU]", "");
			s2 = s2.charAt(0) + s2temp.replaceAll("[AEIOU]", "");
			
			//STEP 3
			int shorter1 = Math.min(s1.length(), s2.length());
			boolean check1 = false;
			if (s1.length() > s2.length()) {
				check1 = true;
			}
			String LtoR1 = "";
			String LtoR2 = "";
			for (int j = 0; j < shorter1; j++) {
				if (s1.charAt(j) != s2.charAt(j)) {
					LtoR1 += s1.charAt(j);
					LtoR2 += s2.charAt(j);
				}
			}
			if (check1) {
				for (int j = shorter1; j < s1.length(); j++) {
					LtoR1 += s1.charAt(j);
				}
			}
			else {
				for (int j = shorter1; j < s2.length(); j++) {
					LtoR2 += s2.charAt(j);
				}
			}
			s1 = LtoR1;
			s2 = LtoR2;

			//STEP 4
			int n1 = s2.length();
			int n2 = s1.length();
			boolean check2 = false;
			if (s1.length() > s2.length()) {
				check2 = true;
				n1 = s1.length();
				n2 = s2.length();
			}
			while (s1.length() != s2.length()) {
				if (check2) {
					s2 = " " + s2;
				}
				else {
					s1 = " " + s1;
				}
			}
			String RtoL1 = "";
			String RtoL2 = "";
			for (int j = n1-1; j > n1-n2; j--) {
				if (s1.charAt(j) != s2.charAt(j)) {
					RtoL1 = s1.charAt(j) + RtoL1;
					RtoL2 = s2.charAt(j) + RtoL2;
				}
			}
			if (check2) {
				for (int j = n1-n2; j >= 0; j--) {
					RtoL1 = s1.charAt(j) + RtoL1;
				}
				RtoL2 = s2.charAt(n1-n2) + RtoL2;
			}
			else {
				for (int j = n1-n2; j >= 0; j--) {
					RtoL2 = s2.charAt(j) + RtoL2;
				}
				RtoL1 = s1.charAt(n1-n2) + RtoL1;
			}
			s1 = RtoL1;
			s2 = RtoL2;

			//PRINT OUTPUT
			String ans = "";
			if (s1.length() < s2.length()) {
				ans = s1;
			}
			else if (s2.length() < s1.length()) {
				ans = s2;
			}
			else {
				if (s1.charAt(0) < s2.charAt(0)) {
					ans = s1;
				}
				else {
					ans = s2;
				}
			}
			System.out.println(ans);
		}
	}
	
	public static String removeDoubleC(String s) {
		String c = "BCDFGHJKLMNPQRSTVWXYZ";
		String str = "";
	    for (int i = 0; i < s.length()-1; i++) {
	    	for (int j = 0; j < 21; j++) {
	    		if (s.charAt(i) == c.charAt(j)) {
	    			if (s.charAt(i) == s.charAt(i+1)) {
	    				break;
	    			}
	    			else {
	    				str += s.charAt(i);
	    				break;
	    			}
	    		}
	    		else if (s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U') {
	    			str += s.charAt(i);
	    			break;
	    		}
	    	}
	    }
	    if (s.charAt(s.length()-1) != s.charAt(s.length()-2)) {
	    	str += s.charAt(s.length()-1);
	    }
	    return str;
	}
}
