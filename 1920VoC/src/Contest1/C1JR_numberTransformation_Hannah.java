package Contest1;
/*
Name: Hannah Moon
Grade: 9
2019-2020 ACSL Contest 1 Junior 5 Division
Team : North Hollywood High School
*/

import java.io.*;

import java.util.*;

public class C1JR_numberTransformation_Hannah {

	static Scanner in;

	static String N;

	static int [] num;

	static int P;

	static int D;

	public static void main(String[] args) throws FileNotFoundException {

		in = new Scanner(new File ("1920c1jr.in"));

		for(int i=0; i<5; i++){

			try {

	            init();

	            solve();

	        }

	        catch(Exception e) {

	            System.out.println("Error");

	            e.printStackTrace();

	        }

		}
		
	}

	static void init () {

		N = in.next();

		P = in.nextInt();

		D = in.nextInt();

		String [] temp = N.split("");

		num = new int [N.length()];

		for (int i = 0; i < temp.length; i++) {

			num[i] = Integer.parseInt(temp[i]);

		}	

	}	

	static void solve () {		

		int temp = num[(num.length)-P];

		if (temp < 5) {

			temp = temp + D;

			String t = Integer.toString(temp);

			String [] tt = t.split("");

			String T = tt[tt.length-1];

			int ttemp = Integer.parseInt(T);

			int index = num.length-P;

			num [index] = ttemp;

			if (index < num.length-1){

				for (int i = index+1; i < num.length; i++) {

					num[i] = 0;

				}

			}

		}

		else {

			temp = temp - D;

			if (temp < 0) temp = temp * -1;

			String t = Integer.toString(temp);

			String [] tt = t.split("");

			String T = tt[0];

			int ttemp = Integer.parseInt(T);

			int index = num.length-P;

			num [index] = ttemp;

			if (index < num.length-1){

				for (int i = index+1; i < num.length; i++) {

					num[i] = 0;

				}

			}

		}

		for (int i = 0; i < num.length; i++) {

			System.out.print(num[i]);

		}

		System.out.println();

		
	}
	
}