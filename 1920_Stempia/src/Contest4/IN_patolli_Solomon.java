package Contest4;
/*
 * Solomon Baik
 * Grade 10
 * STEMPIA
 * Intermediate
 * Contest 4
 */
import java.util.*;
import java.io.*;
public class IN_patolli_Solomon {
	
	static Scanner in;
	static int r;
	static int[] opp = new int[3], board;
	static ArrayList<Integer> rolls, me;
	
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("1920c4in.in"));
		for(int i = 0; i < 5; i++) {
			init();
			solve();
		}
		in.close();
	}
	
	static void init() {
		board = new int[53];
		rolls = new ArrayList<Integer>();
		me = new ArrayList<Integer>();
		for(int i = 0; i < 3; i++)
			opp[i] = in.nextInt();
		for(int i = 0; i < 3; i++)
			me.add(in.nextInt());
		r = in.nextInt();
		while(r-- > 0)
			rolls.add(in.nextInt());
		for(int i = 0; i < 3; i++) {
			board[me.get(i)] = 1;
			board[opp[i]] = 2;
		}
	}
	
	static void solve() {
		for(int i = 0; i < rolls.size(); i++) {
			int num = smallest();
			if(check4(num, i)) {
				if(rolls.get(i) + num == 52) {  //check6
					board[num]= 0;
					me.remove(me.indexOf(num));
					continue;
				}
				else if(rolls.get(i) + num < 52) {
					board[rolls.get(i) + num] = 1;
					board[num] = 0;
				}else {
					continue;
				}
				if(isPrime(num + rolls.get(i)))
					run7(num, i);
				else if(isSquare(num + rolls.get(i)) && num + rolls.get(i) > 4)
					run8(num, i);
				else if(check9(num, i)) {
					run9(num, i);
				}
			}
			updateMe();
		}
		if(me.size() == 0)
			System.out.println("GAME OVER");
		else {
			for(int x = 0; x < me.size(); x++) {
				if(x == me.size() - 1)
					System.out.println(me.get(x));
				else
					System.out.print(me.get(x) + " ");
			}
		}
	}
	
	static int smallest() {
		int min = 53;
		for(int n: me) {
			min = Math.min(min,  n);
		}
		return min;
	}
	
	static boolean check4(int n, int i) {
		if(board[rolls.get(i) + n] == 0)
			return true;
		else
			return false;
	}
	
	static void run7(int n, int i) {//CHECK 47
		for(int x = n + rolls.get(i); x < n + rolls.get(i) + 6; x++) {
			if(board[x] == 0) {
				board[x] = 1;
				board[x - 1] = 0;
			}
			if(board[x + 1] != 0)
				break;
		}
	}
	
	static void run8(int n, int i) {
		for(int x = n + rolls.get(i); x > n + rolls.get(i) - 6; x--) {
			if(board[x] == 0) {
				board[x] = 1;
				board[x + 1] = 0;
			}
			if(board[x - 1] != 0)
				break;
		}
	}
	
	static boolean check9(int n, int i) {
		if(n <= 6 && n + rolls.get(i) >= 8) {
			return true;
		}else if(n <= 6 && n + rolls.get(i) >= 8) {
			return true;
		}else if(n <= 11 && n + rolls.get(i) >= 13) {
			return true;
		}else if(n <= 16 && n + rolls.get(i) >= 18) {
			return true;
		}else if(n <= 21 && n + rolls.get(i) >= 23) {
			return true;
		}else if(n <= 26 && n + rolls.get(i) >= 28) {
			return true;
		}else if(n <= 34 && n + rolls.get(i) >= 36) {
			return true;
		}else if(n <= 39 && n + rolls.get(i) >= 41) {
			return true;
		}else if(n <= 44 && n + rolls.get(i) >= 46) {
			return true;
		}else if(n <= 49 && n + rolls.get(i) >= 51) {
			return true;
		}else
			return false;
	}
	
	static void run9(int n, int i) {
		board[n + rolls.get(i)] = 0;
		board[n] = 1;
		boolean clear = false;
		ArrayList<Integer> multiples = new ArrayList<Integer>();
		for(int x = 1; x <= 52; x++)
			multiples.add(x * rolls.get(i));
		for(int x = 0; x < multiples.size(); x++) {
			if(multiples.get(x) <= n || multiples.get(x) > n + rolls.get(i)) {
				multiples.remove(x);
				x--;
			}
		}
		Collections.sort(multiples);
		for(int x: multiples) {
			if(board[x] == 0) {
				clear = true;
				break;
			}
		}
		if(clear) {
			if(multiples.get(0) == 52) {
				board[n + rolls.get(i)] = 0;
				me.remove(n);
			}else {
				board[n] = 0;
				board[n + rolls.get(i)] = 0;
				board[multiples.get(0)] = 1;
			}
		}else {
			board[n] = 1;
			board[n + rolls.get(i)] = 0;
		}
	}
	
	static boolean isPrime(int n) {
		boolean prime = true;
		for(int divisor = 2; divisor <= n / 2; divisor++) {
		    if (n % divisor == 0) {
		        prime = false;
		        break;
		    }
		}
		return prime;
	}
	
	static boolean isSquare(int n) {
		int round = (int)Math.sqrt(n);
		if(Math.pow(round, 2) == n)
			return true;
		else
			return false;
	}
	
	static void updateMe() {
		me.clear();
		for(int x = 0; x < 53; x++) {
			if(board[x] == 1)
				me.add(x);
		}
	}

}
