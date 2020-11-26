package Contest1;
/*
Name: Clay Shin        
Grade: 10
Team: Stempia 
Division: Intermediate 5
Contest 1
*/

import java.io.*;
import java.util.*;
public class IN_NumberTransformation_Clay {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner (new File("1920c1in.in"));
		for(int i = 0; i<5; i++) {
			String N = in.next();
			int P = in.nextInt();
			int index = N.length()-P;
			int num = N.charAt(index)-'0';
			for(int j = 0; j<index; j++) {
				int temp = N.charAt(j) - '0';
				temp = (temp + num)%10;
				System.out.print(temp);
			}
			System.out.print(num);
			for(int j = index + 1; j < N.length(); j++) {
				int temp = N.charAt(j) - '0';
				temp = Math.abs(temp-num);
				System.out.print(temp);
			}
			System.out.println();
		}
	}
}