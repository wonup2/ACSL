package Contest4;
/*
 * Name: Hemosoo Woo
 * Grade: 9th
 * Team: Stempia
 * Division: Junior Contest 4
 */
import java.util.*;
import java.io.*;
public class JR_4Patolli_Hemosoo {
	static Scanner in;
	static int board[], pos, r[], rolls;
	static boolean win;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920C4JR.in"));
		for(int i = 0; i < 5; i++) {
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
		board = new int[53];
		
		Arrays.fill(board, 0);
		for(int i = 0; i < 3; i++) board[in.nextInt()] = 1;
		pos = in.nextInt();
		rolls = in.nextInt();
		r = new int[rolls];
		for(int i = 0; i < rolls; i++) {
			r[i] = in.nextInt();
		}
		win = false;
	}
	public static void solve() {
		for(int i = 0; i < rolls; i++) {  							
			int num = r[i];											
			pos += num;												
			if(pos == 52) {
				System.out.println("GAME OVER");
				win = true;
				break;
			} else if(pos > 52) {
				pos  = pos-num;
				continue;
			}
			if(board[pos] == 1) {
				pos = pos - num;
				continue;
			}
			if(pos == 52) {
				System.out.println("GAME OVER");
				win = true;
				break;
			} else if(pos > 52) {
				pos  = pos-num;
			}
			if(ifPrime(pos) == true) {							
				int hold = pos;
				for(int j = 0; j <= 6; j++) {
					if(board[pos + j] == 1) {
						pos = j + pos - 1;
						break;
					}
					else if(j == 6) {
						pos += 6;
					}
				}
				if(pos > 52) {
					pos = hold;
				}
			}
			else if((int)Math.sqrt(pos) * (int)Math.sqrt(pos) == pos  && pos+6 <=52 && pos > 4) {		
				for(int j = 0; j <= 6; j++) {
					if(pos <= 6) {
						pos = 1;
					}
					else if(board[pos - j] == 1) {
						pos = pos - j + 1;
						break;
					}
					else if(j == 6) {
						pos = pos-6;
					}
				}
			}
			else {
				if(rule9(pos, num) == true) {								
					int hold = pos;
					pos = pos - (pos%num) ;
					if(board[pos] == 1) {
						pos = hold - num;
					}
				}
			}
			
		}
		if(win != true) {
			System.out.println(pos);										
		}
	}
	public static boolean ifPrime(int n) {
		for(int i = 2; i <= n/2; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
	public static boolean rule9(int n, int r) {
		int e = n - r;
		if(e >= 2 && e <= 6 && n >= 8 && n <= 12) {
			return true;
		} else if(e >= 7 && e <= 11 && n >= 13 && n <= 17) {
			return true;
		} else if(e >= 12 && e<= 16 && n >= 18 && n <= 22) {
			return true;
		} else if(e >= 17 && e<= 21 && n >= 23 && n <= 27) {
			return true;
		} else if(e >= 22 && e <= 26 && n >= 28 && n <= 32) {
			return true;
		} else if(e >= 30 && e <= 34 && n >= 36 && n <= 40) {
			return true;
		} else if(e >= 35 && e <= 39 && n >= 41 && n <= 45) {
			return true;
		} else if(e >= 40 && e <= 44 && n >= 46 && n <= 50) {
			return true;
		} else if(e >= 45 && e <= 49 && n >= 51 && n <= 52) {
			return true;
		}
		
		return false;
	}
}
 