package Contest4;

//Minjun Kim

import java.util.*;
import java.io.*;

public class JR_Patrolli_Minjun {
	
	static Scanner in;
	static int[] moves;
	static HashSet<Integer> no;
	static int n,x,count, end;
	static boolean check;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("1920C4jr.in"));
			
			for(int i = 0; i < 5; i++) {
				init();
				System.out.println(solve());
			}
			
			in.close();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		no = new HashSet<Integer>();
		for(int i = 0; i < 3; i++) {
			no.add(in.nextInt());
		}
		
		x = in.nextInt();
		n = in.nextInt();
		moves = new int[n];
		
		for(int i = 0; i < n; i++) {
			moves[i] = in.nextInt();
		}
		
	}
	
	private static String solve() {
		count = 0;
		check = true;
		end = x;
		while(check == true && count < n) {
			turn(count);
			count++;
		}
		
		
		if(end == 52) {
			return "GAME OVER";
		}
		else {
			return Integer.toString(end);
		}
	}
	
	private static void turn(int c) {
		int start = end;
		end = start+moves[c];
		
		
		if(no.contains(end)) {
			end = start;
			return;
		}
		if(end == 52) {
			check = false;
			end = 52;
			return;
		}
		if(end > 52) {
			end = start;
			return;
		}
		if(end == 2 || end == 3 || end == 5 || end == 7 || end == 11 || end == 13 || end == 17 || end == 19 || end == 23 || end == 29 || end == 31 || end == 37 || end == 41|| end == 43 || end == 47) {
			for(int i = 0; i < 6; i++) {
				end++;
				if(no.contains(end)) {
					end--;
					return;
				}
			}
			return;
		}
		if(end == 9 || end == 16 || end == 25 || end == 36 || end == 49) {
			for(int i = 0; i < 6; i++) {
				end--;
				if(no.contains(end)) {
					end++;
					return;
				}
			}
			return;
		}
		if(start <= 6 && end >= 8 || start <= 11 && end >= 13 || start <= 16 && end >= 18 || start <= 21 && end >= 23 || start <= 26 && end >= 28 || start <= 34 && end >= 36 || start <= 39 && end >= 41 || start <= 44 && end >= 46 || start <= 49 && end >= 51) {
			int multiple = 0;
			for(int i = end; i >= start; i--) {
				if(i%moves[c] == 0) {
					multiple = i;
					break;
				}
			}
			
			if(no.contains(multiple)) {
				end = start;
				return;
			}
			else {
				end = multiple;
				return;
			}
		}
		
	}

}
