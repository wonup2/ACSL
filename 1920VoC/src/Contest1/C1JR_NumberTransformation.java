package Contest1;
/*
Name: Samuel Nam
Grade: 9
2019-2020 ACSL Contest 1 Junior 5 Division
Team : North Hollywood High School
Date: 12/4/2019
*/

import java.io.*;
import java.util.*;
public class C1JR_NumberTransformation {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("1920c1jr.in"));
		for(int z=0; z<5; z++){
		long n = in.nextLong();
		int p = in.nextInt();
		int d = in.nextInt();
		
		long pos = (long) Math.round(Math.pow(10, p));
		long temp1 = n/pos;
		long temp2 = n%pos;
		long temp = (int) (temp2/(pos/10));
		String t = "";
		char num = 'a';
		if(temp>4){
			t = Math.abs(temp-d)+"";
			num = t.charAt(0);
		}
		else{
			t = (temp+d)+"";
			num = t.charAt(t.length()-1);
		}
		
		String temp3 = "";
		for(int i=0; i<p-1; i++){
			temp3=temp3+"0";
		}
		String ans = "";
		if(temp1!=0)
			ans = "" + temp1 + num + temp3;
		else
			ans = "" + num + temp3;
		System.out.println(ans);
		}
	}

}
