package Contest2;
/*
Name: Jaden Chung
Grade: 9
Team: Stempia
Division: Junior5
Date: 12/24/2019 Contest2
*/

import java.util.*;
import java.io.*;

public class jr_Stempia_Jaden {

	public static void main(String[] args) throws IOException{
		
		Scanner in = new Scanner(new File("1920c2JR.in"));
		
		for(int q = 0; q < 5; q++) {
			String s1 = in.next();
			String s2 = in.next();
			
			s1 = removeDC(s1);
			s2 = removeDC(s2);
			
			s1 = removeVowel(s1);
			s2 = removeVowel(s2);
			
			System.out.println(LtoRRtoL(s1, s2));
			
		}
		
	}
	
	public static String removeDC(String s1) {
		for(int i = 1; i < s1.length(); i++) {
			if(s1.charAt(i-1)==s1.charAt(i)) {
				s1=s1.substring(0, i-1)+s1.substring(i, s1.length());
			}
		}
		return s1;
	}
	
	public static String removeVowel(String s) {
		String c = s.charAt(0)+"";
		s=s.substring(1, s.length()).replaceAll("[A,E,I,O,U]", "");
		return c+s;
	}
	
	public static String LtoRRtoL(String s1, String s2) {
		
		for(int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
			if(s1.charAt(i)==s2.charAt(i)) {
				s1=s1.substring(0, i)+s1.substring(i+1, s1.length());
				s2=s2.substring(0, i)+s2.substring(i+1, s2.length());
				i--;
			}
		}
		
		s1 = new StringBuilder(s1).reverse().toString();
		s2 = new StringBuilder(s2).reverse().toString();
		//System.out.println(s1);
		
		for(int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
			if(s1.charAt(i)==s2.charAt(i)) {
				s1=s1.substring(0, i)+s1.substring(i+1, s1.length());
				s2=s2.substring(0, i)+s2.substring(i+1, s2.length());
				i--;
			}
		}
		
		s1 = new StringBuilder(s1).reverse().toString();
		s2 = new StringBuilder(s2).reverse().toString();
		
		if(s1.length()<s2.length()) {
			return s1;
		}
		else if(s1.length()>s2.length()) {
			return s2;
		}
		else {
			if(s1.charAt(0)<s2.charAt(0)) {
				return s1;
			}
			else {
				return s2;
			}
		}
		//return s1;
	}
	
}
