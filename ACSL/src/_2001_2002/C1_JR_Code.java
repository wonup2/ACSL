package _2001_2002;

import java.util.*;
import java.io.*;


public class C1_JR_Code {

	static Scanner in;
	static int n;
	static char ans;
	
	public static void main(String[] args) throws IOException {
		
		in = new Scanner(new File("0102c1jr.in"));
		for(int i=0; i<10; i++) {
			init();
			solve();
		}	
		
		in.close();
	}
	
	static void init(){
		n = in.nextLine().charAt(0) - 64;
	}
	
	static void solve() {
		//process 1		
		if(1<=n && n <=5) n *=2;
		else if(6<=n && n <=10) n = n%3*5;
		else if(11<=n && n <=15) n = n/4*8;
		else if(16<=n && n <=20) n = (n%10+n/10)*10;
		else n = fact(n)*12;
		
		//process 2
		if(n==0) ans = '#';
		n%=26;
		if(n==0) n = 26;		
		ans = (char)(n+64);
		
		//output
		System.out.println(ans);
	}	
	
	static int fact(int n) {
		
		for(int i=n-1; i>=2; i--) {
			if(n % i == 0) return i;
		}
		
		return 1;
	}
}


/*
A
B
C
D
E

*/