

import java.util.*;
import java.io.*;


public class A3_ACSLbet {
	static Scanner input;
	static String word, binWord;
	static ArrayList<String> bin;
	public static void main(String[] args) throws IOException {
		input = new Scanner(System.in);
		try {
			init();
			solve();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void init() {
		word = input.nextLine();
		binWord = "";
		for(int i = 0; i < word.length(); i ++) {
			if(word.charAt(i) == '*') {
				binWord += Integer.toBinaryString(27);
			}
			else if(word.charAt(i) == '/') {
				binWord += Integer.toBinaryString(28);
			} 
			else if(word.charAt(i) == '$') {
				binWord += Integer.toBinaryString(29);
			}
			else if(word.charAt(i) == '%') {
				binWord += Integer.toBinaryString(30);
			}
			else if(word.charAt(i) == '#') {
				binWord += Integer.toBinaryString(31);
			}
			else {
				binWord += Integer.toBinaryString(word.charAt(i) - 64);
			}
		}
	}
	public static void solve() {
		System.out.println(binToString((circle(2, false, binWord))));
		System.out.println(binToString((shift(4, true, binWord))));
		System.out.println(binToString((circle(10, true, binWord))));
		System.out.println(binToString((shift(8, false, binWord))));
		System.out.println(binToString((circle(5, false, shift(3, true, binWord)))));
		System.out.println(binToString((shift(5, false, circle(8, true, binWord)))));
		System.out.println(binToString(and(shift(2, true, binWord), circle(4, false, binWord))));
		System.out.println(binToString(or(circle(3, false, binWord), circle(6, true, binWord))));
		System.out.println(binToString(notOr(shift(9, false, binWord), circle(7, false, binWord))));
		System.out.println(binToString(or(and(circle(2, false, binWord), shift(1, true, binWord)), circle(4, true, binWord))));
	}
	public static String shift(int times, Boolean right, String word) {
		String a = "";
		times = times % word.length();
		for(int i = 0; i < times; i ++) {
			a += "0";
		}
		if(right)
			return a + word.substring(0, word.length() - times);
		else 
			return word.substring(times) + a;
	}
	public static String circle(int times, Boolean right, String word) {
		times = times % word.length();
		if(right)
			return word.substring(word.length() - times) + word.substring(0, word.length() - times);
		else
			return word.substring(times) + word.substring(0, times);
	}
	public static String binToString(String bin) {
		String ent = "";
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '*', '/', '$', '%', '#'};
		for(int i = bin.length(); i > bin.length() % 5; i -= 5) {
			String temp = bin.substring(i - 5, i);
			int temp2 = 0;
			for(int a = 0; a < 5; a ++) {
				temp2 += Math.pow(2, 5 - a - 1) * (temp.charAt(a) - '0');
			}
			if(temp2 != 0)
				ent = letters[temp2 - 1] + ent;
		}
		String temp = bin.substring(0, bin.length() % 5);
		int temp2 = 0;
		for(int i = 0; i < temp.length(); i ++) {
			temp2 += Math.pow(2, temp.length() - i - 1) * (temp.charAt(i) - '0');
		}
		if(temp2 != 0)
			ent = letters[temp2 - 1] + ent;
		return ent;
	}
	public static String and(String a, String b) {
		String temp = "";
		for(int i = 0; i < a.length(); i ++) {
			if(a.charAt(i) == '1' && b.charAt(i) == '1')
				temp += '1';
			else
				temp += '0';
		}
		return temp;
	}
	public static String or(String a, String b) {
		String temp = "";
		for(int i = 0; i < a.length(); i ++) {
			if(a.charAt(i) == '1' || b.charAt(i) == '1')
				temp += '1';
			else
				temp += '0';
		}
		return temp;
	}
	public static String notOr(String a, String b) {
		String temp = "";
		for(int i = 0; i < a.length(); i ++) {
			if((a.charAt(i) - '0') + (b.charAt(i) - '0') == 1)
				temp += '1';
			else
				temp += '0';
		}
		return temp;
	}

}
