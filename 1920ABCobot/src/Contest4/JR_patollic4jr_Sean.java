package Contest4;
import java.io.*;
import java.util.*;

public class JR_patollic4jr_Sean {
	static Scanner in;
	static boolean[] oboard;
	static int ans;
	static int[] rolls;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920c4jr.in"));
		for(int i = 0; i < 5; i++) {
			try {
				init();
				solve();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		in.close();
	}
	public static void init() {
		oboard = new boolean[53];
		for(int  i = 0; i < 3; i++) {
			int ind = in.nextInt();
			oboard[ind] = true;
		}
		ans = in.nextInt();
		int tn = in.nextInt();
		rolls = new int[tn];
		for(int  i = 0; i < tn; i++) {
			rolls[i] = in.nextInt();
		}
	}
	public static void solve() {
		for(int i = 0; i < rolls.length; i++) {
			int nw = ans + rolls[i];
			if(nw == 52) {
				ans = 52;
				break;
			}else if(nw > 52) {
				continue;
			}else if(oboard[nw]) {
				continue;
			}else if(isPrime(nw)) {	
				for(int j = 1; j < 7; j++) {
					if(!oboard[nw+1]) {
						nw++;
					}else {
						break;
					}
				}
			}else if(isSquare(nw)) {	
				for(int j = 1; j < 7; j++) {
					if(!oboard[nw-1]) {
						nw--;
					}else {
						break;
					}
				}
			}else if(isRule9(nw, ans)) {	
				for(int j = nw; j >=ans; j--) {
					if(j % rolls[i]==0) {
						if(!oboard[j]) {
							nw=j;
							break;
						}else {
							nw = ans;
						}
					}
					
				}
			}
			ans = nw;
		}
		if(ans == 52) {
			System.out.println("GAME OVER");
		}else {
			System.out.println(ans);
		}
	}
	public static boolean isRule9(int end, int str) {
		if(str < 3 && end > 3) {
			return true;
		}
		if(str < 7 && end > 7) {
			return true;
		}
		if(str < 12 && end > 12) {
			return true;
		}
		if(str < 17 && end > 17) {
			return true;
		}
		if(str < 22 && end > 22) {
			return true;
		}
		if(str < 27 && end > 27) {
			return true;
		}
		if(str < 35 && end > 35) {
			return true;
		}
		if(str < 40 && end > 40) {
			return true;
		}
		if(str <45 && end >45) {
			return true;
		}
		if(str <50 && end >50) {
			return true;
		}
		return false;
	}
	public static boolean isPrime(int num) {
		for(int i=2; i<num/2; i++) {
			if(num % i==0) {
				return false;
			}
		}
		return true;
	}
	public static boolean isSquare(int num) {
		if(num == 9 || num == 16 || num == 25 || num == 36 || num == 49) {
			return true;
		}
		return false;
	}
}