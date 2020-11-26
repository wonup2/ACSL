package Contest4;
import java.util.*;
import java.io.*;


public class JR_Patolli2_Joseph {
	static Scanner input;
	static int m1, m2, m3, totMove, currentM, futM, moveNum;
	static int[] moves;
	public static void main(String[] args) throws IOException {
		input = new Scanner(new File("1920c4Jr.in"));
		for(int count = 0; count < 5; count ++) {
			try {
				init();
				solve();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void init() {
		m1 = input.nextInt();
		m2 = input.nextInt();
		m3 = input.nextInt();
		currentM = input.nextInt();
		totMove = input.nextInt();
		moves = new int[totMove];
		for(int i = 0; i < totMove; i ++) {
			moves[i] = input.nextInt();
		}
		
		
		
	}
	public static void solve() {
		for(int i = 0; i < totMove; i ++) {
			futM = currentM + moves[i];
			moveNum = i;
			if(futM != m1 && futM != m2 && futM != m3) {
				if(primeNumCheck()) {
					if(futM < 53 && futM != m1 && futM != m2 && futM != m3)
						currentM = futM;
					else
						currentM = futM - 1;
				}
				else if(squareNumCheck()) {
					if(futM != m1 && futM != m2 && futM != m3)
						currentM = futM;
					else
						currentM = futM + 1;
				}
				else if(vertCheck()) {
					if(futM < 53 && futM != m1 && futM != m2 && futM != m3) {
						currentM = futM;
					}
				}
				else {
					if(futM < 53 && futM != m1 && futM != m2 && futM != m3)
						currentM = futM;
				}
				
			}
		}
		
		if(currentM == 52)
			System.out.println("GAME OVER");
		else
			System.out.println(currentM);
		
	}
	public static Boolean primeNumCheck() {
		Boolean check = false;
		int[] primeNum = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
		for(int c = 0; c < primeNum.length; c ++) {
			if(futM == primeNum[c]) {
				Boolean stuck = true;
				c = primeNum.length;
				check = true;
				int count = 1;
				while(stuck && count < 6) {
					if(futM + count == m1 || futM + count == m2 || futM + count == m3) {
						futM += count;
						futM --;
						stuck = false;
						return true;
					}
					
					count ++;
					
				}
				futM += count;
				return true;
			}
		}
		return check;
	}
	public static Boolean squareNumCheck() {
		int[] squareNum = {9, 16, 25, 36, 49};
		Boolean check = false;
		for(int c = 0; c < squareNum.length; c ++) {
			if(futM == squareNum[c]) {
				Boolean stuck = true;
				check = true;
				int count = 1;
				while(stuck && count < 6) {
					if(futM - count == m1 || futM - count == m2 || futM - count == m3) {
						futM -= count;
						futM ++;
						stuck = false;
						return true;
					}
					count ++;
				}
				futM -= count;
				return true;
			}
			
		}
		return check;
	}
	public static Boolean vertCheck() {
		int b = futM;
		int[] vert = {6, 11, 16, 21, 26, 34, 39, 44, 49};
		//            8  13  18  23  28  36  41  46  51
		for(int i = 0; i < vert.length; i ++) {
			if(currentM <= vert[i] && futM >= vert[i] + 2) {
				for(int c = futM; c >= currentM; c --) {
					if(c % moves[moveNum] == 0) {
						futM = c;
						return true;
					}
				}
			}
		}
		return b != futM;
	}

}
