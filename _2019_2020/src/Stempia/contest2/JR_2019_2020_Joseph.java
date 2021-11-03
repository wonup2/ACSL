package Stempia.contest2;
/*
Joseph Jang
7th grade
ABCobot
Junior 5
Contest 2
*/

import java.util.*;
import java.io.*;
public class JR_2019_2020_Joseph {
		static Scanner input;
		static String a, b;
	public static void main(String[] args) throws IOException {
		input = new Scanner(new File("1920c2jr.in"));
		for(int count = 0; count < 5; count ++) {
			try {
				init();
				solve();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void init() throws IOException {
		a = input.next();
		b = input.next();
	}
	public static void solve() throws IOException {
		char e = ' ';
		String a2 = a.charAt(0)+""; String b2 = b.charAt(0)+"";
		
		for(int count = 1; count < a.length(); count ++) {
			if(a.charAt(count) != a.charAt(count-1) && checkVowels(a.charAt(count))) {
				a2 += a.charAt(count);
			}
		}
		for(int count = 1; count < b.length(); count ++) {
			if(b.charAt(count) != b.charAt(count-1) && checkVowels(b.charAt(count))) {
				b2 += b.charAt(count);
			}
		}
		a = a2; b = b2; a2 = a.charAt(0)+""; b2 = b.charAt(0)+"";
		for(int count = 1; count < a.length(); count ++) {
			if(a.charAt(count) != 'A' && a.charAt(count) != 'E' && a.charAt(count) != 'I' && a.charAt(count) != 'O' && a.charAt(count) != 'U') {
				a2 += a.charAt(count);
			}
		}
		for(int count = 1; count < b.length(); count ++) {
			if(b.charAt(count) != 'A' && b.charAt(count) != 'E' && b.charAt(count) != 'I' && b.charAt(count) != 'O' && b.charAt(count) != 'U') {
				b2 += b.charAt(count);
			}
		}
		a = a2; b = b2; a2 = a.charAt(0)+""; b2 = b.charAt(0)+"";
		String[] list = check(a, b);
		a = reverse(list[0]); b = reverse(list[1]);
		list = check(a, b);
		list[0] = reverse(list[0]); list[1] = reverse(list[1]);
		if(list[0].length() > list[1].length()) {
			System.out.println(list[1]);
		}
		else if(list[0].length() < list[1].length()) {
			System.out.println(list[0]);
		}
		else if(list[0].compareTo(list[1]) < 0) {
			System.out.println(list[0]);
		}
		else {
			System.out.println(list[1]);
		}
	}
	public static String reverse(String a) {
		String b = "";
		for(int c = 0; c < a.length(); c++) {
			b = a.charAt(c) + b;
		}
		return b;
	}
	public static String[] check(String a, String b) {
		String a2 = ""; String b2 = "";
		if(a.length() > b.length()) {
			for(int count = 0; count < b.length(); count ++) {
				if(a.charAt(count) != b.charAt(count)) {
					a2+=a.charAt(count);
					b2+=b.charAt(count);
				}
			}
			for(int count = b.length(); count < a.length(); count ++) {
				a2+=a.charAt(count);
			}
		}
		else {
			for(int count = 0; count < a.length(); count ++) {
				if(a.charAt(count) != b.charAt(count)) {
					a2+=a.charAt(count);
					b2+=b.charAt(count);
				}
			}
			for(int count = a.length(); count < b.length(); count ++) {
				b2+=b.charAt(count);
			}
		}
		String[] ans = {a2, b2};
		return ans;
	}
	public static boolean checkVowels(char b) {
		if(b != 'A' && b != 'E' && b != 'I' && b != 'O' && b != 'U') {
			return true;
		}
		return false;
	}
	public static String[] duplicate(String a, String b) {
		String a2 = ""; String b2 = "";
		for(int count = 0; count < b.length(); count ++) {
			if(a.charAt(count) != b.charAt(count)) {
				a2+=a.charAt(count);
				b2+=b.charAt(count);
			}
		}
		for(int count = b.length(); count < a.length(); count ++) {
			a2+=a.charAt(count);
		}
		String[] list = {a2, b2};
		return list;
	}

}
