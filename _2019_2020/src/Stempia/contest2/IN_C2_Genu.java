package Stempia.contest2;
//Genu Lee
//ABCobot Intermediate 5
//Contest 2

import java.util.*;
import java.io.*;

public class IN_C2_Genu {

	static Scanner in;
	static String a, b;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920c2in.in"));
		for(int i=0; i<5; i++) {
			init();
			solve();
		}
	}
	
	static void init() {
		a = in.next();
		b = in.next();
	}
	
	static void solve() {
		remove(); 
		
		while(true) {
			if(shift()) remove();
			else break;
		}
		
		System.out.println(calculate());		
	}
	
	static void remove() {

		for(int i=0; i<a.length() && i<b.length(); i++) {
			if(a.charAt(i)==b.charAt(i)) {
				a=a.substring(0,i)+a.substring(i+1);
				b=b.substring(0,i)+b.substring(i+1);
				i--;
			}
		}		
	}
	
	static boolean shift() {
		a=a+"0";
		b=b+"1";
		for(int i=0; i<a.length()-1 && i<b.length()-1; i++) {
			
			if(b.charAt(i+1)==a.charAt(i)) {
				b=b.substring(0,i)+b.substring(i+1);
				a=a.replace("0","");
				b=b.replace("1","");
				return true;
			}
			
			if(a.charAt(i+1)==b.charAt(i)) {
				a=a.substring(0,i)+a.substring(i+1);
				a=a.replace("0","");
				b=b.replace("1","");
				return true;
			}
		}	
		a=a.replace("0","");
		b=b.replace("1","");
		return false;
	}		
	
	static int calculate() {
		int n=0;
		int min = Math.min(a.length(), b.length());
		for(int i=0; i<min; i++) 
			n += (a.charAt(i)-b.charAt(i));
		
		n+= a.length()-min + b.length()-min;  
		return n;
	}
}
