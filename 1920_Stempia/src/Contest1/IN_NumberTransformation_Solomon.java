package Contest1;
/*
Name: Solomon Baik
Grade: 10
Team: Stempia 
Division: Intermediate 5
Contest 1
*/

import java.util.*;
import java.io.*;
public class IN_NumberTransformation_Solomon {
	
	static Scanner in;
	static String n;
	static int p, ans;
	
	public static void main(String[] args)throws IOException {
		
		in = new Scanner(new File("1920c1in.in"));
		
		for(int i = 0; i < 5; i++) {
			try {
				init();
				solve();
			}
			catch(Exception e) {
				in.nextLine();
				System.out.println("Error");
			}
		}
		in.close();
	}
	
	static void init() {
		n = in.next();
		p = in.nextInt();
		ans = 0;
	}
	
	static void solve() {
		
		int num1 = n.charAt(n.length() - p) - '0';
		int num2 = 0;
		
		for(int x = 0; x < n.length() - p; x++) {
			
			num2 = n.charAt(x) - '0';
			ans = (num1 + num2) % 10;
			System.out.print(ans);
		}
		
		System.out.print(num1);
		
		for(int x = n.length() - p + 1; x < n.length(); x++) {
			
			num2 = n.charAt(x) - '0';
			ans = Math.abs(num1 - num2);
			System.out.print(ans);			
		}		
		
		System.out.println();
	}

}
