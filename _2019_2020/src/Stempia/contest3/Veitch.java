package Stempia.contest3;
//Erin Kim 10th
//ABCobot Intermediate 3
//Contest 3

import java.util.*;
import java.io.*;

public class Veitch {
	static Scanner in;
	static String components, answer, value;
	static int hex;
	static String [] grid = {"*A*B~C~D", "*A*B*C~D", "~A*B*C~D", "~A*B~C~D", "*A*B~C*D", "*A*B*C*D", "~A*B*C*D", "~A*B~C*D", "*A~B~C*D", "*A~B*C*D", "~A~B*C*D", "~A~B~C*D", "*A~B~C~D", "*A~B*C~D", "~A~B*C~D", "~A~B~C~D"};
	static String [] splitOr;
	static int [] binary;
	
	public static void main(String [] args) throws IOException{
		in = new Scanner(new File("1920c3in.in"));
		
		for(int x = 0; x < 5; x++) {
			try {
				init();
				solve();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void init() throws IOException {
		binary = new int [16];
		splitOr = in.nextLine().replace("+", " ").split(" ");
		answer = "";
	}
	
	public static void solve() throws IOException {
		for(int i = 0; i < splitOr.length; i++) {
			splitOr[i] = convert(splitOr[i]);
		}
		for(int i = 0; i < grid.length; i++) {
			String alg = grid[i];
			for(String j: splitOr) {
				boolean ok = true;
				for(int k = 0; k < j.length(); k += 2) {
					if(!alg.contains(j.substring(k, k + 2))) {
						ok = false;
						break;
					}
				}
				if(ok) {
					binary[i] = 1;
					break;
				}
			}
		}
		
		for(int i = 0; i < 16; i += 4) {
			hex = (8 * binary[i]) + (4 * binary[i + 1]) + (2 * binary[i + 2]) + (binary[i + 3]);
			if(hex >= 10) {
				answer += toHex(hex);
			} else {
				answer += hex;
			}
		}
		System.out.println(answer);
	}
	
	public static String convert(String a) {
		components = "";
		for(int j = 0; j < a.length(); j++) {
			if(a.charAt(j) != '~') {
				components += "*";
				components += a.charAt(j);
			} else {
				components += "~";
				j++;
				components += a.charAt(j);
			}
		}
		return components;
	}
	
	public static String toHex(int num) {
		value = "A";
		if(num == 11) {	
			value = "B";
		} else if(num == 12) {
			value = "C";
		} else if(num == 13) {
			value = "D";
		} else if(num == 14) {
			value = "E";
		} else if(num == 15) {
			value = "F";
		}
		return value;
	}
}