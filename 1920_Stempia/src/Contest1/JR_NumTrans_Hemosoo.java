package Contest1;
/*
Name: Hemosoo Woo
Grade: 9
Team: Stempia 
Division: Junior 5
Contest 1
*/

import java.util.*;
import java.io.*;
public class JR_NumTrans_Hemosoo {
	static Scanner in;
	static String N, result;
	static int P, D, hold;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920c1jr.in"));
		for(int i = 0; i < 5; i++) {
			try {
				init();
				solve();
			}
			catch(Exception e) {
				System.out.println("Error");
			}
		}
		in.close();
	}
	public static void init() {
		result = "";
		N = in.next();
		P = in.nextInt();
		D = in.nextInt();
	}
	public static void solve() {
		
		hold = N.length() - P;
		
		int number = N.charAt(hold)-'0';
		
		if(number >= 0 && number <= 4) D += number;
				
		else if(number >= 5 && number <= 9) D =  Math.abs(number-D);
		
		D %= 10;
		
		for(int i = 0; i < N.length(); i++) {
			
			if(i == hold) result += D + "";
			
			else if(i > hold) result += "0";
			
			else result += N.charAt(i);		
			
		}
		
		System.out.println(result);
	}
}
