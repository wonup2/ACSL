package Stempia.contest2;
import java.util.*;

import java.io.*;

public class IN_sameness_Rachel {

	/*

	 * Name: Rachel Lee

	 * Grade: 11

	 * Division: Intermediate

	 * Contest2

	 */

	static Scanner in;

	static String a1, a2;

	public static void main(String [] args) throws IOException {

		in = new Scanner(new File("1920C2IN.in"));

		for(int i = 0; i < 5; i++) {

			try {

				init();

				solve();

			}catch(Exception e) {

				e.printStackTrace();

			}

		}

		in.close();

	}

	static void init() throws IOException{

		a1 = in.next();

		a2 = in.next();

	}

	static void solve() {

		removeDupl();

		while(true) {

			if(shiftCheck()) {

				removeDupl();

			}else {

				break;

			}

		}

		System.out.println(calculate());

	}

		static void removeDupl() {

			for(int i = 0; i < a1.length() && i < a2.length(); i++) {

				if(a1.charAt(i) == a2.charAt(i)) {

					a1 = a1.substring(0,i) + a1.substring(i+1);

					a2 = a2.substring(0,i) + a2.substring(i+1);

					i--;

				}

			}

		}

		static boolean shiftCheck() {

			a1 = a1+"0";

			a2 = a2+"1";

			for(int i = 0; i < a1.length()-1 && i < a2.length()-1; i++){

				if(a1.charAt(i) == a2.charAt(i+1)) {

					a2 = a2.substring(0,i) + a2.substring(i+1, a2.length()-1);

					reset();

					return true;

				}

				if(a2.charAt(i) == a1.charAt(i+1)) {

					a1 = a1.substring(0,i) + a1.substring(i+1);

					reset();

					return true;

				}

			}

			reset();

			return false;

		}

		static int calculate() {

			int sum = 0;

			int min = Math.min(a1.length(), a2.length());

			for(int i = 0; i < min; i++) {

				sum += (a1.charAt(i) - a2.charAt(i));

			}

			

			sum += (a1.length() - min) + (a2.length()-min);

			return sum;

		}

		static void reset() {

			a1 = a1.replace("0", "");

			a2 = a2.replace("1", "");

		}

}