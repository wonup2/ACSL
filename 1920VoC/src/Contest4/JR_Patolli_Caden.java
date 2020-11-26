package Contest4;
/*
Name: Caden Kang
Grade: 9
Team: Voice of Calling
Division: Junior
Date: 4/6/2020
2019-2020 ACSL Contest 4
*/

import java.util.*;
import java.io.*;

public class JR_Patolli_Caden {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("1920C4JR.in"));

		for (int i = 0; i < 5; i++) {
			int[] board = new int[53];
			for (int j = 0; j < 3; j++) {
				board[in.nextInt()] = 1;
			}
			int loc = in.nextInt();
			int r = in.nextInt();
			int[] rolls = new int[r];
			for (int j = 0; j < r; j++) {
				rolls[j] = in.nextInt();
			}

			for (int j = 0; j < r; j++) {
				loc = loc + rolls[j];
				if (loc > 52 || board[loc] == 1) {
					loc = loc - rolls[j];
				}
				else if (loc == 52) {
					break;
				}
				else if(prime(loc)) {
					for (int k = 0; k < 6; k++) {
						if (board[loc + 1] == 1) {
							break;
						}
						loc++;
					}
				}
				else if ((int)(Math.sqrt(loc)) == Math.sqrt(loc) && loc > 4) {
					for (int k = 0; k < 6; k++) {
						if (board[loc - 1] == 1) {
							break;
						}
						loc--;
					}
				}
				else if (RuleNine(loc - rolls[j], loc)) {
					boolean check = false;
					int temp = loc;
					for (int k = temp - rolls[j]; k <= temp; k++) {
						if (k % rolls[j] == 0 && board[k] == 0) {
							loc = k;
							check =  true;
						}
					}
					if (!check) {
						loc -= rolls[j];
					}
				}
			}
			if (loc < 52) {
				System.out.println(loc);
			}
			else {
				System.out.println("GAME OVER");
			}
		}
	}
	
	public static boolean prime(int loc) {
		boolean prime = true;
		for (int k = 2; k < loc; k++) {
			if (loc % k == 0) {
				prime = false;
			}
		}
		return prime;
	}

	public static boolean RuleNine (int n1, int n2) {
		if (n1 >= 3 && n1 <= 6 && n2 >= 8 && n2 <= 12)
			return true;
		if (n1 >= 8 && n1 <= 11 && n2 >= 13 && n2 <= 17)
			return true;
		if (n1 >= 13 && n1 <= 16 && n2 >= 18 && n2 <= 22)
			return true;
		if (n1 >= 18 && n1 <= 21 && n2 >= 23 && n2 <= 27)
			return true;
		if (n1 >= 22 && n1 <= 26 && n2 >= 28 && n2 <= 32)
			return true;
		if (n1 >= 30 && n1 <= 34 && n2 >= 36 && n2 <= 40)
			return true;
		if (n1 >= 36 && n1 <= 39 && n2 >= 41 && n2 <= 45)
			return true;
		if (n1 >= 41 && n1 <= 44 && n2 >= 46 && n2 <= 50)
			return true;
		if (n1 >= 46 && n1 <= 49 && n2 >= 51 && n2 <= 52)
			return true;
		if (n1 == 2 && n2 == 8)
			return true;
		if (n1 == 7 && n2 == 13)
			return true;
		if (n1 == 12 && n2 == 18)
			return true;
		if (n1 == 17 && n2 == 23)
			return true;
		if (n1 == 22 && n2 == 28)
			return true;
		if (n1 == 35 && n2 == 41)
			return true;
		if (n1 == 40 && n2 == 46)
			return true;
		if (n1 == 45 && n2 == 51)
			return true;
		
		return false; 
	}
}
