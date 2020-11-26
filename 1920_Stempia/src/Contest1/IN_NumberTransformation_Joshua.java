package Contest1;
/*
Name: Joshua Nam
Grade: 10
Team: Stempia 
Division: Intermediate 5
Contest 1
*/

import java.util.*;
import java.io.*;
public class IN_NumberTransformation_Joshua {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("1920c1in.in"));
		for(int z = 0; z < 5; z++) {
			String num = in.next();
			String res = "";
			int pos = in.nextInt();
			int x = Integer.parseInt(num.charAt(num.length()-pos)+"");
			for(int i = 0; i < num.length()-pos; i++) {
				res += ((Integer.parseInt(num.charAt(i)+"") + x)%10)+"";
			}
			res += x;
			for(int i = num.length()-pos+1; i < num.length(); i++) {
				res += Math.abs((Integer.parseInt(num.charAt(i)+"") - x))+"";
			}
			System.out.println(res);
		}
	}
}
