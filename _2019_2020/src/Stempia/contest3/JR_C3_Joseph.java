package Stempia.contest3;
/*
Joseph Jang
7th grade
ABCobot
Junior 5
Contest 3
*/

import java.util.*;
import java.io.*;

public class JR_C3_Joseph {
	static Scanner input;
	static int[][] bin;
	static int tots;
	static String tot;
	public static void main(String[] args) throws IOException {
		try {
			input = new Scanner(new File("1920C3JR.in"));
			for(int count = 0; count < 5; count ++) {
				init();
				solve();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void init() {
		String samp = input.nextLine();
		samp = samp.toLowerCase();
		String fin = hexToBin(samp);
		tots = 0;
		bin = new int[2][4];
		for(int c = 0; c < 2; c ++) {
			for(int b = 0; b < 4; b ++) {
				bin[c][b] = fin.charAt(0);
				bin[c][b] -= '0';
				fin = fin.substring(1);
			}
		}
	}
	public static void solve() {
		tot = "";
		int j;
		if(checkAll(bin, 0)) {
			tot += "B";
			for(int c = 0; c < 4; c ++) {
				bin[0][c] = 0;
			}
		}
		j = checkSquare(bin);
		if(j != -1) {
			if(tot.length() != 0) {
				tot += " + ";
			}
			if(j == 0) {
				tot += "A";
			}
			else if(j == 1) {
				tot += "C";
			}
			else if(j == 2) {
				tot += "~A";
			}
			else if(j == 3) {
				tot += "~C";
			}
			bin[0][j] = 0;
			bin[1][j] = 0;
			bin[0][(j + 1) % 4] = 0;
			bin[1][(j + 1) % 4] = 0;
		}
		if(checkAll(bin, 1)) {
			if(tot.length() != 0) {
				tot += " + ";
			}
				tot += "~B";
				for(int c = 0; c < 4; c ++) {
					bin[1][c] = 0;
				}
		}
		
		
		for(int count2 = 0; count2 < 2; count2 ++) {
			for(int count = 0; count < 3; count ++) {
				if(checkSide(bin, count, count2)) {
					bin[count2][count] = 0;
					bin[count2][(count + 1) % 4] = 0;
					if(tot.length() != 0) {
						tot += " + ";
					}
					//System.out.println(count);
					if(count == 0)
					tot += "A";
					if(count == 2)
						tot += "~A";
					if(count2 == 0) {
						tot += "B";
					}
					if(count2 == 1) {
						tot += "~B";
					}
					
					if(count == 1)
						tot += "C";
					
					
					if(count == 3)
						tot += "~C";
					
				}
			}
		}
		for(int count = 0; count  < 4; count ++) {
			if(checkUp(bin, count)) {
				bin[0][count] = 0;
				bin[1][count] = 0;
				if(tot.length() != 0) {
					tot += " + ";
				}
				if(count == 0)
					tot += "A~C";
				if(count == 1)
					tot += "AC";
				if(count == 2)
					tot += "~AC";
				if(count == 3)
					tot += "~A~C";
			}
		}
		
		if(checkSide(bin, 3, 0)) {
			if(tot.length() != 0) {
				tot += " + ";
			}
			bin[0][3] = 0;
			bin[0][0] = 0;
			tot += "B";
			tot += "~C";
			
		}
		if(checkSide(bin, 3, 1)) {
			if(tot.length() != 0) {
				tot += " + ";
			}
			bin[1][3] = 0;
			bin[1][0] = 0;
			tot += "~B";
			tot += "~C";
			
		}
		
		check();
		System.out.println(tot);
	}


	public static String hexToBin(String samp) {
		int a;
		String fin = "";
		if(samp.charAt(0) - '0' <= 9) {
			a = samp.charAt(0);
			a -= '0';
			if(a >= 8) {
				a -= 8;
				fin += "1";
				tots ++;
			}
			else {
				fin += "0";
			}
			if(a >= 4) {
				a -= 4;
				fin += "1";
				tots ++;
			}
			else {
				fin += "0";
			}
			if(a >= 2) {
				a -= 2;
				fin += "1";
				tots ++;
			}
			else {
				fin += "0";
			}
			if(a >= 1) {
				a -= 1;
				fin += "1";
				tots ++;
			}
			else {
				fin += "0";
			}
		}
		else {
			a = samp.charAt(0);
			
			a = a % 97 + 10;
			if(a >= 8) {
				a -= 8;
				fin += "1";
				tots ++;
			}
			else {
				fin += "0";
			}
			if(a >= 4) {
				a -= 4;
				fin += "1";
				tots ++;
			}
			else {
				fin += "0";
			}
			if(a >= 2) {
				a -= 2;
				fin += "1";
				tots ++;
			}
			else {
				fin += "0";
			}
			if(a >= 1) {
				a -= 1;
				fin += "1";
				tots ++;
			}
			else {
				fin += "0";
			}
		}
		
		if(samp.charAt(1) - '0' <= 9) {
			a = samp.charAt(1);
			
			a -= '0';
			if(a >= 8) {
				a -= 8;
				fin += "1";
				tots ++;
			}
			else {
				fin += "0";
			}
			if(a >= 4) {
				a -= 4;
				fin += "1";
				tots ++;
			}
			else {
				fin += "0";
			}
			if(a >= 2) {
				a -= 2;
				fin += "1";
				tots ++;
			}
			else {
				fin += "0";
			}
			if(a >= 1) {
				a -= 1;
				fin += "1";
				tots ++;
			}
			else {
				fin += "0";
			}
		}
		else {
			a = samp.charAt(1);
			
			a = a % 97 + 10;
			
			if(a >= 8) {
				a -= 8;
				fin += "1";
				tots ++;
			}
			else {
				fin += "0";
			}
			if(a >= 4) {
				a -= 4;
				fin += "1";
				tots ++;
			}
			else {
				fin += "0";
			}
			if(a >= 2) {
				a -= 2;
				fin += "1";
				tots ++;
			}
			else {
				fin += "0";
			}
			if(a >= 1) {
				a -= 1;
				fin += "1";
				tots ++;
			}
			else {
				fin += "0";
			}
		}
		//System.out.println(fin);
		return fin;
	}
	public static Boolean checkAll(int[][] a, int b) {
		if(a[b][0] == 1 && a[b][1] == 1 && a[b][2] == 1 && a[b][3] == 1)
			return true;
		//System.out.println(tot);

		return false;
	}
	public static int checkSquare(int[][] a) {
		for(int c = 0; c < 3; c ++) {
			if(a[0][c] == 1 && a[1][c] == 1 && a[0][c + 1] == 1 && a[1][c + 1] == 1) {
				return c;
			}
		}
		if(a[0][0] == 1 && a[1][0] == 1 && a[0][3] == 1 && a[1][3] == 1) {
			return 3;
		}
		return -1;
	}
	public static Boolean checkSide(int[][] a, int b, int c) {
		if(a[c][b] == 1 && a[c][(b + 1) % 4] == 1)
			return true;
		return false;
	}
	public static Boolean checkUp(int[][]a, int b) {
		if(a[0][b] == 1 && a[1][b] == 1)
			return true;
		return false;
	}
	public static void check() {
		for(int count = 0; count < 2; count ++) {
			for(int count2 = 0; count2 < 4; count2 ++) {
				if(bin[count][count2] == 1) {
					if(tot.length() != 0)
						tot += " + ";
					
					if(count2 == 0 || count2 == 1)
						tot += "A";
					if(count2 == 2 || count2 == 3)
						tot += "~A";
					
					if(count == 0)
						tot += "B";
					else {
						tot += "~B";
					}
					if(count2 == 0 || count2 == 3)
						tot += "~C";
					if(count2 == 1 || count2 == 2)
						tot += "C";
				}
			}
		}
	}
}


