package Stempia.contest4;
import java.util.*;
import java.io.*;

public class JR_patolli_Colin {
	static Scanner in;
	static String[] s;
	static int[] OP;
	static boolean[] Passed;
	static int P;
	static int[] rolls;
	
	
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("1920c4jr.in"));
		
		for(int i=0; i<5; i++) {
			try {
				init();
				solve();
			}
			catch(Exception e) {
				System.out.println("Error");
				e.printStackTrace();
			}
		}
		in.close();		
	}
		
	static void init() {
		s = in.nextLine().split(" ");
		OP = new int[3];
		Passed = new boolean[3];
		OP[0] = Integer.parseInt(s[0]);
		OP[1] = Integer.parseInt(s[1]);
		OP[2] = Integer.parseInt(s[2]);
		
		P = Integer.parseInt(s[3]);

		
		rolls = new int[Integer.parseInt(s[4])];
		for(int j = 0; j < rolls.length; j++) {
			rolls[j] = Integer.parseInt(s[5+j]);
		}
	}
		
	static void solve() {
		boolean exceed = false;
		for(int j = 0; j < rolls.length; j++) {
		
			P += rolls[j];
			if(P > OP[0]) {
				Passed[0] = true;
			}
			if(P > OP[1]) {
				Passed[1] = true;
			}
			if(P > OP[2]) {
				Passed[2] = true;
			}
			if(P == 52) {
				exceed = true;
				System.out.println("GAME OVER");
				break;
			}else if(P > 52) {
				P -= rolls[j];
			}else if(P == OP[0] || P == OP[1] || P == OP[2]) {
				P-= rolls[j];
				continue;
			}else {
				if(Prime(P) == true) {
					if(P + 6 > OP[0] && Passed[0] == false) {
						P = OP[0]-1;
					}else if(P + 6 > OP[1] && Passed[1] == false){
						P = OP[1]-1;
					}else if(P + 6 > OP[2] && Passed[2] == false){
						P = OP[2]-1;

					}else {
						P+=6;
					}
				}else if(Math.sqrt(P) >= 4.0 && Math.sqrt(P) % 1 == 0.0) {

					if(P - 6 <= OP[0] && Passed[0] == true) {
						P = OP[0]+1;
						check();
					}else if(P - 6 <= OP[1] && Passed[1] == true){
						P = OP[1]+1;
						check();
					}else if(P - 6 <= OP[2] && Passed[2] == true){
						P = OP[2]+1;
						check();
					}else {
						P-=6;
						check();
					}
				}else if(rule9(P, rolls[j]) == true){
					P = r9(P, rolls[j], OP);
					check();
				}
			}
		}
		if(exceed == false) {
			System.out.println(P);
		}
	}
	public static void check() {
		for(int j = 0; j < OP.length; j++) {
			if(OP[j] > P) {
				Passed[j] = false;
			}
		}
	}
	private static int r9(int p, int roll, int[] OP) {
		int multiple = 0;
		
		for(int j = 0; j <= p; j+= roll) {
				multiple = j;
			
		}
		if(multiple == OP[0] || multiple == OP[1] || multiple == OP[2]) {
			multiple = p-roll;
		}
		
		return multiple;
	}

	private static boolean rule9(int P, int roll) {
		int before = P-roll;
		for(int j = 8; j <= 52; j+= 5) {
			if(j == 52) {
				j--;
			}
			if(j == 33) {
				j -= 1;
				continue;
			}
			if(P >= j && before < j &&  before != j-1) {
				return true;
			}
		}
		return false;
	}

	private static boolean Prime(int P) {
		int remainder = 0;
		boolean isPrime = true;
		
		for(int j = 2; j < P; j++) {
			remainder = P%j;
			if(remainder == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
