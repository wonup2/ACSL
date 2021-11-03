package Stempia.contest2;
/*
Name: Andrew Kim
Grade: 9
Team: ABCobot
Division: Junior5
Contest2
*/

import java.io.*;
import java.util.Scanner;

public class JR_StringDifferences_Andrew {
	static Scanner in;
	static String input1;
	static String input2;
	
	public static void main (String args[]) throws IOException {
		in = new Scanner(new File("1920c2jr.in"));
		for(int gLoop = 0; gLoop < 5; gLoop++) {			
			input1 = in.next();
			input2 = in.next();
			solve();
		}
	}
	
	public static void solve() {
		// Removing the double consonants
		String inputa = input1.substring(0,1);
		String inputb = input2.substring(0,1);
		
		for(int i = 0; i < input1.length()-1; i++) {
			if(input1.charAt(i) != input1.charAt(i+1)) {
				inputa += input1.charAt(i+1);
			}
		}
		
		for(int i = 0; i < input2.length()-1; i++) {
			if(input2.charAt(i) != input2.charAt(i+1)) {
				inputb += input2.charAt(i+1);
			}
		}
		
		// Removing the vowels
		String inputaa = inputa.substring(0,1);
		String inputbb = inputb.substring(0,1);
		
		for(int i = 1; i < inputa.length(); i++) {
			if(inputa.charAt(i) != 'A' && inputa.charAt(i) != 'E' && inputa.charAt(i) != 'I' && inputa.charAt(i) != 'O' && inputa.charAt(i) != 'U') {
				inputaa += inputa.charAt(i);
			}
		}
		
		for(int i = 1; i < inputb.length(); i++) {
			if(inputb.charAt(i) != 'A' && inputb.charAt(i) != 'E' && inputb.charAt(i) != 'I' && inputb.charAt(i) != 'O' && inputb.charAt(i) != 'U') {
				inputbb += inputb.charAt(i);
			}
		}
		
		//Removing letters from L to R in same location
		String inputaaa = "";
		String inputbbb = "";
		
		if(inputaa.length() < inputbb.length()) {
			for(int i = 0; i < inputaa.length(); i++){
				if(inputaa.charAt(i) != inputbb.charAt(i)) {
					inputaaa += inputaa.charAt(i);
					inputbbb += inputbb.charAt(i);
				}
			}
			for(int i = inputaa.length(); i < inputbb.length(); i++) {
				inputbbb += inputbb.charAt(i);
			}
		}else {
			for(int i = 0; i < inputbb.length(); i++){
				if(inputaa.charAt(i) != inputbb.charAt(i)) {
					inputaaa += inputaa.charAt(i);
					inputbbb += inputbb.charAt(i);
				}
			}
			for(int i = inputbb.length(); i < inputaa.length(); i++) {
				inputaaa += inputaa.charAt(i);
			}
		}
		
		//Removing letters from R to L in same location
		String inputaaaa = "";
		String inputbbbb = "";
		String afinal = "";
		String bfinal = "";
		String x = "";
		String y = "";
		
		for(int i = inputaaa.length()-1; i >= 0; i--) {
			x += inputaaa.charAt(i);
		}
		for(int i = inputbbb.length()-1; i >= 0; i--) {
			y += inputbbb.charAt(i);
		}
		
		if(x.length() < y.length()) {
			for(int i = 0; i < x.length(); i++){
				if(x.charAt(i) != y.charAt(i)) {
					inputaaaa += x.charAt(i);
					inputbbbb += y.charAt(i);
				}
			}
			for(int i = x.length(); i < y.length(); i++) {
				inputbbbb += y.charAt(i);
			}
		}else {
			for(int i = 0; i < y.length(); i++){
				if(x.charAt(i) != y.charAt(i)) {
					inputaaaa += x.charAt(i);
					inputbbbb += y.charAt(i);
				}
			}
			for(int i = y.length(); i < x.length(); i++) {
				inputaaaa += x.charAt(i);
			}
		}

		for(int i = inputaaaa.length()-1; i >= 0; i--) {
			afinal += inputaaaa.charAt(i);
		}
		for(int i = inputbbbb.length()-1; i >= 0; i--) {
			bfinal += inputbbbb.charAt(i);
		}
		
		//Solve
		if(afinal.length() < bfinal.length()) {
			System.out.println(afinal);
		}
		if(afinal.length() > bfinal.length()) {
			System.out.println(bfinal);
		}
		if(afinal.length() == bfinal.length()) {
			if(afinal.compareTo(bfinal) < 0) {
				System.out.println(afinal);
			}else {
				System.out.println(bfinal);
			}
		}
	}
}
