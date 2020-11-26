package Contest1;
/*
Name: Catherine Cho
Grade: 9
Team: Stempia 
Division: Junior 5
Contest 1
*/


import java.util.*;
import java.io.*;
public class JR_numberTransformation_Catherine {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("1920c1jr.in"));
		for(int t = 0; t < 5; t++) {
			String n = Long.toString(in.nextLong());
			int p = in.nextInt();
			int d = in.nextInt();
			int[] list= new int[n.length()];
			for(int i = 0; i < n.length(); i++) {
				list[i] = Integer.parseInt(n.substring(i,i+1));
			}
			int num = list[list.length-p];
			if(num == 0 || num == 1||num == 2||num == 3||num == 4) {
				num += d;
				while(num>=10) {
					num = num% 10;
				}
				list[list.length - p] = num;
			}else {
				num = Math.abs(num-d);
				while(num>=10) {
					num = num/ 10;
				}
				list[list.length-p] = num;
			}
			
			if(p!= list.length-1) {
				for(int i = list.length - p +1 ; i < list.length; i++) {
					list[i] = 0;
				}
			}
			for(int i = 0; i < list.length; i++) {
				System.out.print(list[i]);
			}
			
			System.out.println();
		}
		
	}
}
