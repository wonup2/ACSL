package Contest2;
/*
name: Erin Kang
grade: 10th
team: ABCobot
division: Intermediate 5
Contest 2
*/

import java.util.*;
import java.io.*;

public class samenessFactor_Erin {
	static Scanner in;
	static int shiftAlert, sum;
	static String temp1, temp2;
	static ArrayList<Character> s1, s2;
	
	public static void main(String [] args) throws IOException {
		in = new Scanner(new File("1920C2in.in"));
		for(int i=0; i<5; i++) {
			try {
				init();
				solve();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void init() throws IOException{
		temp1 = in.next();
		temp2 = in.next();
		
		sum = 0;		
		s1 = new ArrayList<Character>();
		s2 = new ArrayList<Character>();
		for (char a : temp1.toCharArray()) {
			  s1.add(a);
		}
		for (char a : temp2.toCharArray()) {
			  s2.add(a);
		}
	}
	
	public static void solve() throws IOException{
		int small = Math.min(s1.size(), s2.size());
		shiftAlert = small;
		
		do {
			shiftAlert = small;
			for(int i = 0; i < small; i++) {
				if(s1.get(i) == s2.get(i)) {
					s1.remove(i);
					s2.remove(i);
					small--;
					i--;
				}
			}
			small = Math.min(s1.size(), s2.size());
			for(int i = 0; i < small - 1; i++) {
				if(s1.get(i) == s2.get(i + 1)) {
					s1.remove(i);
					s2.remove(i);
					s2.remove(i);
					i--;
					break;
				}
				if(s2.get(i) == s1.get(i + 1)) {
					s2.remove(i);
					s1.remove(i);
					s1.remove(i);
					i--;
					break;
				}
			}
			small = Math.min(s1.size(), s2.size());
		} while(small != shiftAlert);
		
		int leftover = Math.max(s1.size(), s2.size()) - small;
		for(int i = 0; i < small; i++) {
			sum += s1.get(i) - s2.get(i);
		}
		sum += leftover;
		
		System.out.println(sum);
	}
}