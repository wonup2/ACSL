package Stempia.contest2;
/*
Sean Kim
8th grade
ABCobot
Junior 5
Contest 2
*/

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class JR_C2_StrDiff_Sean {
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
        a = removeDouble(a);
        b = removeDouble(b);
        
        a = isVowel(a);
        b = isVowel(b);
        
        removeSameLocationSameCharacter();
       
        a = reverse(a);
        b = reverse(b);
        
        removeSameLocationSameCharacter();
        
        a = reverse(a);
        b = reverse(b);
        
        if(a.length() < b.length()) {
        	System.out.println(a);
        }else {
        	System.out.println(b);
        }
    }
    
    static String removeDouble(String c) { 
        for(int i = 0; i < c.length()-1; i++) {
        	if(c.substring(i,i+1).equals(c.substring(i+1,i+2)) && !c.substring(i,i+1).equals("A") && !c.substring(i,i+1).equals("E") && !c.substring(i,i+1).equals("I") && !c.substring(i,i+1).equals("O") && !c.substring(i,i+1).equals("U")) {
        		c = c.substring(0,i) + c.substring(i+1);
        	}
        }
        return c;
    }
    
    static void removeSameLocationSameCharacter() {
        int temp = Math.min(a.length(), b.length());
        for(int i = 0; i < temp; i++) {	 
        	if(a.substring(i,i+1).equals(b.substring(i,i+1))) {
        		a = a.substring(0,i) + a.substring(i+1);
        		b = b.substring(0,i) + b.substring(i+1);
        		temp--;
        		i--;
        	}
        } 
       
    }
    
    static String isVowel(String c) {
    	for(int i = 0; i < c.length(); i++) {
        	if(i != 0 && c.substring(i,i+1).equals("A") || c.substring(i,i+1).equals("E") || c.substring(i,i+1).equals("I") || c.substring(i,i+1).equals("O") || c.substring(i,i+1).equals("U")) {
        		c = c.substring(0,i) + c.substring(i+1);
        		i--;
        	}
        }
    	return c;
    }
    
    static String reverse(String s) {
    	String replace = "";        
        for(int i = s.length(); i > 0; i--) {
        	replace += s.substring(i-1,i);
        }
        return replace;
    }
}
