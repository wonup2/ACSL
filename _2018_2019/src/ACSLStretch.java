

import java.util.*;
import java.io.*;

public class ACSLStretch {

	static Scanner in;
	static int r, c, s, n, currentPos;
	static ArrayList<Integer> block;
	static String ans;
	static boolean check;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("1819ASC.in"));
			//for(int i = 0; i < 10; i++) {	
				init();
				System.out.println(solve());
			//}
			
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static void init() {
		r = in.nextInt();
		c = in.nextInt();
		s = in.nextInt();
		currentPos = s;
		n = in.nextInt();
		
		check = false;
		ans = "";
		
		block = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
			block.add(in.nextInt());
		}
		
		System.out.println(block);
	}
	
	private static String solve() {
		while(check == false) {
			System.out.println(currentPos);
			b(); 			System.out.println(currentPos);
			if(check==true) break;
			
			c();			System.out.println(currentPos);
			if(check==true) break;
			
			d();			System.out.println(currentPos);
			if(check==true) break;
			
			e();			System.out.println(currentPos);
			if(check==true) break;
			
			a();			System.out.println(currentPos);
			if(check==true) break;
		}
		
		return ans;
	}
	private static void a() {
		if(currentPos % c == 0 || currentPos % c == c-1) return;
		if(((currentPos+2)/c+1)*c == r*c) {
			ans += "a";
			check = true;
			return;
		}
		else if(((currentPos+2)/c+1)*c <= r*c && currentPos+2 <= (currentPos)/c+1 && !block.contains(currentPos) && !block.contains(currentPos+1) && !block.contains(currentPos+2)) {
			ans += "a";
			block.add(currentPos);
			block.add(currentPos+1);
			block.add(currentPos+2);
			currentPos = currentPos+2+c;
			return;
		}
		else if(currentPos != s && currentPos-c+1 >= 1 && currentPos <= r*c && currentPos/c+1 != (currentPos-c+1)/c+1) {
			currentPos = currentPos-c+1;
			if(currentPos % c == 0) return;
			if(((currentPos+2)/c+1)*c <= r*c && currentPos+2 <= (currentPos)/c+1 && !block.contains(currentPos) && !block.contains(currentPos+1) && !block.contains(currentPos+2)) {
				ans += "a";
				block.add(currentPos);
				block.add(currentPos+1);
				block.add(currentPos+2);
				currentPos = currentPos+2+c;
				return;
			}
			else return;
		}
		else return;
		
	}
	
	private static void b() {
		if(((currentPos+c+c)/c+1)*c == r*c) {
			ans += "b";
			check = true;
			return;
		}
		if(((currentPos+c+c)/c+1)*c <= r*c && !block.contains(currentPos) && !block.contains(currentPos+c) && !block.contains(currentPos+c+c)) {
			ans += "b";
			block.add(currentPos);
			block.add(currentPos+c);
			block.add(currentPos+c+c);
			currentPos = currentPos+c+c;
			return;
		}
		else if(currentPos != s && currentPos-c+1 >= 1 && currentPos <= r*c && currentPos/c+1 != (currentPos-c+1)/c+1) {
			currentPos = currentPos-c+1;
			if(((currentPos+c+c)/c+1)*c <= r*c && !block.contains(currentPos) && !block.contains(currentPos+c) && !block.contains(currentPos+c+c)) {
				ans += "b";
				block.add(currentPos);
				block.add(currentPos+c);
				block.add(currentPos+c+c);
				currentPos = currentPos+c+c+c;
				return;
			}
			else return;
		}
		else return;
	}
	
	private static void c() {
		if(currentPos % c == 0) return;
		if(((currentPos+c+1)/c+1)*c == r*c) {
			check = true;
			ans+="c";
			return;
		}
		if(((currentPos+c+1)/c+1)*c <= r*c && !block.contains(currentPos) && !block.contains(currentPos+c) && !block.contains(currentPos+c+1)) {
			ans += "c";
			block.add(currentPos);
			block.add(currentPos+c);
			block.add(currentPos+c+1);
			currentPos = currentPos+c+1+c;
			return;
		}
		else if(currentPos != s && currentPos-c+1 >= 1 && currentPos <= r*c && currentPos/c+1 != (currentPos-c+1)/c+1) {
			currentPos = currentPos-c+1;
			if(currentPos % c == 0) return;
			if(((currentPos+c+1)/c+1)*c <= r*c && !block.contains(currentPos) && !block.contains(currentPos+c) && !block.contains(currentPos+c+1)) {
				ans += "c";
				block.add(currentPos);
				block.add(currentPos+c);
				block.add(currentPos+c+1);
				currentPos = currentPos+c+1+c;
				return;
			}
			else return;
		}
		else return;
	}

	private static void d() {
		if(currentPos % c == 0) return;
		if(((currentPos+c+c+1)/c+1)*c <= r*c) {
			ans+="d";
			check = true;
			return;
		}
		if(((currentPos+c+c+1)/c+1)*c <= r*c && !block.contains(currentPos) && !block.contains(currentPos+1) && !block.contains(currentPos+c+1) && !block.contains(currentPos+c+c+1)) {
			ans += "d";
			block.add(currentPos);
			block.add(currentPos+c);
			block.add(currentPos+c+c);
			block.add(currentPos+c+c+1);
			currentPos = currentPos+c+c+1+c;
			return;
		}
		else if(currentPos != s && currentPos-c+1 >= 1 && currentPos <= r*c && currentPos/c+1 != (currentPos-c+1)/c+1) {
			currentPos = currentPos-c+1;
			if(currentPos % c == 0) return;
			if(((currentPos+c+c+1)/c+1)*c <= r*c && !block.contains(currentPos) && !block.contains(currentPos+1) && !block.contains(currentPos+c+1) && !block.contains(currentPos+c+c+1)) {
				ans += "d";
				block.add(currentPos);
				block.add(currentPos+c);
				block.add(currentPos+c+c);
				block.add(currentPos+c+c+1);
				currentPos = currentPos+c+c+1+c;
				return;
			}
			else return;
		}
		else return;
	}
	
	private static void e() {
		if(currentPos % c == 0 || currentPos % c == c-1) return;
		if(((currentPos+c+2)/c+1)*c <= r*c) {
			ans+="e";
			check = true;
			return;
		}
		if(((currentPos+c+2)/c+1)*c <= r*c && !block.contains(currentPos) && !block.contains(currentPos+1) && !block.contains(currentPos+1+c) && !block.contains(currentPos+2+c)) {
			ans += "e";
			block.add(currentPos);
			block.add(currentPos+1);
			block.add(currentPos+1+c);
			block.add(currentPos+2+c);
			currentPos = currentPos+2+c+c;
			return;
		}
		else if(currentPos != s && currentPos-c+1 >= 1 && currentPos <= r*c && currentPos/c+1 != (currentPos-c+1)/c+1) {
			currentPos = currentPos-c+1;
			if(currentPos % c == 0) return;
			if(((currentPos+c+2)/c+1)*c <= r*c && !block.contains(currentPos) && !block.contains(currentPos+1) && !block.contains(currentPos+1+c) && !block.contains(currentPos+2+c)) {
				ans += "e";
				block.add(currentPos);
				block.add(currentPos+1);
				block.add(currentPos+1+c);
				block.add(currentPos+2+c);
				currentPos = currentPos+2+c+c;
				return;
			}
			else return;
		}
		else return;
	}

}
