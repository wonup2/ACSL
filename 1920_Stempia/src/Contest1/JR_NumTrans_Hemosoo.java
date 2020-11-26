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
		if(Character.getNumericValue(N.charAt(hold)) >= 0 && Character.getNumericValue(N.charAt(hold)) <= 4) {
			D += Character.getNumericValue(N.charAt(hold));
		}
		else if(Character.getNumericValue(N.charAt(hold)) >= 5 && Character.getNumericValue(N.charAt(hold)) <= 9) {
			D =  Math.abs(Character.getNumericValue(N.charAt(hold))-D);
		}
		D = D%10;
		for(int i = 0; i < N.length(); i++) {
			if(i == hold) {
				result += D + "";
			}
			else if(i > hold) {
				result += "0";
			}
			else {
				result += N.charAt(i);
			}
		}
		System.out.println(result);
	}
}
