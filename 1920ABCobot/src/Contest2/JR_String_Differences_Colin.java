package Contest2;
/*
 * Name: Colin Kwon
 * Grade: 9th
 * Team: ABCobot
 * Division: Junior
 * Contest 2
 */

import java.util.*;
import java.io.*;


public class JR_String_Differences_Colin {
	static Scanner in;
	static String word1;
	static String word2;
	public static void main(String[] args) throws IOException {
	
	    in = new Scanner(new File("1920c2JR.in"));
	
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
		word1 = in.next();
		word2 = in.next();	       
	}
	
	static void solve() {
	
		word1 = duplicate(word1);
		word2 = duplicate(word2);
		
		word1 = word1.substring(0,1)+word1.substring(1).replaceAll("[AEIOU]","");
		word2 = word2.substring(0,1)+word2.substring(1).replaceAll("[AEIOU]","");
		
		same();
		
		
		word1 = reverse(word1);
		word2 = reverse(word2);
		same();
		
		
		word1 = reverse(word1);
		word2 = reverse(word2);
		
		checkAns();
	}
	
	//searching for duplicate letters
	private static String duplicate(String word) {
		String ans = "";
		ans += word.charAt(0);
		for(int i=1; i<word.length(); i++){
		    if(word.charAt(i) != word.charAt(i-1))
		      ans +=word.charAt(i);
		    }
		return ans;
	}
	
	
	//left to right
	private static void same() {
		for(int i=0; i<word1.length() && i<word2.length(); i++){
	       if(word1.charAt(i)==word2.charAt(i)){
	         word1 = word1.substring(0,i)+word1.substring(i+1);
	         word2 = word2.substring(0,i)+word2.substring(i+1);
	         i--;
	       }
	    }
	}
	
	//reversing the string
	private static String reverse(String word) {
		String ans = "";
		for(int j = word.length()-1; j >= 0; j--) {
			ans += word.charAt(j);
		}
		return ans;
	}
	
	//finding the answer
	private static void checkAns() {
		if(word2.length() == word1.length()) {
		    if(word2.compareTo(word1) > 0) {
		    	System.out.println(word1);
		    }
		    else {
		    	System.out.println(word2);
		    }		    
		}
		else if(word2.length() > word1.length()) {
		   	System.out.println(word1);
		}
		else {
		    System.out.println(word2);
		}
	}       	
}