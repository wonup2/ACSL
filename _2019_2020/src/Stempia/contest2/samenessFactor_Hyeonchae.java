package Stempia.contest2;
/*
name: Hyeonchae Kim
grade: 10th
team: ABCobot
division: Intermediate 5
Contest 2
*/
import java.util.*;
import java.io.*;

public class samenessFactor_Hyeonchae {
	
	static Scanner in;
	static String first, second;
	static int ans;
	
	public static void main(String [] args) throws FileNotFoundException {
		
		in = new Scanner(new File("1920c2in.in"));
		
		for(int i = 0; i < 10; i++) {
		
			try {
			
				init();
				solve();
			
			}catch(Exception e) {
			
				e.printStackTrace();
			
			}
		
		}
		
	}
	
	public static void init() {
		
		String[] temp = in.nextLine().split(" ");
		first = temp[0];
		second = temp[1];
		
		ans = 0;
		
	}
	
	public static void solve() {
		
		while(true) {
			
			remove();
			if(!shift())
				break;
			
		}
		
		for(int i = 0; i < Math.min(first.length(), second.length()); i++) {
			
			ans += first.charAt(i) - second.charAt(i);
			
		}
		ans += Math.max(first.length(), second.length()) - Math.min(first.length(), second.length());
		
		System.out.println(ans);
		
	}
	
	public static void remove() {
		
		for(int i = 0; i < first.length(); i++) {
			
			if(i < second.length() && first.charAt(i) == second.charAt(i)) {
				
				first = first.substring(0,i) + first.substring(i+1);
				second = second.substring(0,i) + second.substring(i+1);
				i--;
				
			}
			
		}
		
	}
	
	public static boolean shift() {
		
		for(int i = 0; i < Math.min(first.length(), second.length()); i++) {
			
			if(i + 1 < second.length() && first.charAt(i) == second.charAt(i+1)) {
				
				second = second.substring(0,i) + second.substring(i+1);
				return true;
				
			}
		
			if(i + 1 < first.length() && second.charAt(i) == first.charAt(i+1)) {
				
				first = first.substring(0,i) + first.substring(i+1);
				return true;
				
			}
			
		}
		
		return false;
		
	}

}
