package Contest1;
//Andrew Kim
//ABCobot Junior 5
//Contest 1

import java.io.*;
import java.util.Scanner;

public class NumberTransformation_Andrew {
	static Scanner in;
	
	public static void main (String args[]) throws IOException{
		in = new Scanner(new File("c1jr.in"));
		for(int gLoop = 0; gLoop < 5; gLoop++) {
			solve();
		}
	}
	
	public static void solve() {
	
		String N = in.next(); 
		int P = in.nextInt();
		int D = in.nextInt();
		int z = N.length() - P;
		int num = N.charAt(z) - '0';
		char a = '0';
		
		if(num >= 0 && num <= 4) {
			num = num + D;
            a = (num+"").charAt(0);
			
		}else {
            num = Math.abs(num-D);
			a = (num+"").charAt(0);
		}
      
        for(int i = 0; i < N.length(); i++) {
			if(i<z) System.out.print(N.charAt(i));
            else if(i==z) System.out.print(a);
            else System.out.print(0);
		}
		System.out.println();
	}
}