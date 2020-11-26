package _2002_2003;

import java.util.*;
import java.io.*;

public class C1_JR_Asterisks {
	static Scanner in;
	static char c;
	static int n1, n2;

	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("0203c1jr.in"));
		for(int i=0; i<4; i++) {
			init();
			solve();
		}
		in.close();

	}
	static void init() {
		c = in.next().charAt(0);
		n1 = in.nextInt();
		if(c=='B') n2 = in.nextInt();
	}

	static void solve() {
		if(c=='S') {
			for(int i=0; i<n1;i++) {
				for(int j=0; j<=n1; j++) {
					System.out.print('*');
				}
				System.out.println();
			}
			System.out.println();
		}
		else if(c=='H') {
			for(int i=0; i<n1; i++) {
				for(int j=0; j<i; j++) {
					System.out.print(" ");
				}
				for(int j=n1; j>i; j--) {
					System.out.print('*');
				}
				System.out.println();
			}
		}
		else if(c=='L') {
			for(int i=0; i<n1; i++) {
				for(int j=0; j<=i; j++) {
					System.out.print('*');
				}	
				System.out.println();
			}
		}
		else if(c=='B') {
			for(int i=0; i<n2; i++) {
				for(int j=0; j<n1; j++) {
					System.out.print('*');
				}
				System.out.println();
			}
			
		}
	}

}
