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
	static int p;
	static StringBuilder ans;
	
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
		ans = new StringBuilder();
	}
	
	static void solve() {
		for(int x = 0; x < n.length() - p; x++) {
			ans.append(((n.charAt(n.length() - p) - '0') + (n.charAt(x) - '0'))%10);
		}
		ans.append(n.charAt(n.length() - p));
		for(int x = n.length() - p + 1; x < n.length(); x++) {
			ans.append(Math.abs(n.charAt(n.length() - p) - n.charAt(x)));
		}
		System.out.println(ans);
	}

}
