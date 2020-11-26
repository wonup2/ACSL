package Contest1;
/*
Name: Caden Kang
Grade: 9
2019-2020 ACSL Contest 1 Junior 5 Division
Team: North Hollywood High School
*/

import java.util.*;
import java.io.*;

public class C1JR_Caden {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("1920c1jr.in"));
		
		for (int i = 0; i < 5; i++) {
			String s = in.next();
			int p = in.nextInt();
			int d = in.nextInt();
			
			int digit = Integer.parseInt(s.substring(s.length() - p, s.length() - p + 1));
			int change = 0;
			if (digit >= 0 && digit <= 4) {
				change = digit + d;
				change = change % 10;
			}
			if (digit >= 5 && digit <= 9) {
				change = Math.abs(digit - d);
				while (change >= 10) {
					change /= 10; 
				}
			}
			
			int temp = p - 1;
			String n = s.substring(0, s.length() - p) + change;
			for (int j = 0; j < temp; j++) {
				n += "0";
			}
			
			System.out.println(n);
		}
	}
}
