package Contest4;
import java.util.*;
import java.io.*;

public class IN_Patolli_Clay {

	static ArrayList<Integer> op, player, dice, occ;
	static Scanner in;
	public static void main(String[] args) throws IOException {

			in = new Scanner(new File("1920c4in.in"));
			for (int i = 0; i < 5; i++) {
				try {
				init();
				solve();
			
	}	 catch (Exception e) {
			e.printStackTrace();
			}
		}
	}

	public static void init() {
		op = new ArrayList<Integer>();
		player = new ArrayList<Integer>();
		dice = new ArrayList<Integer>();

		for (int i = 0; i < 3; i++)
			op.add(in.nextInt());
		for (int i = 0; i < 3; i++)
			player.add(in.nextInt());
		int n = in.nextInt();
		for (int i = 0; i < n; i++)
			dice.add(in.nextInt());

	}

	public static void solve() {
		for (int die : dice) {
			Collections.sort(player);
			int cur = player.get(0);
			int next = cur + die;
			//System.out.println(cur + " + " + die + " = " + next);

			if(next == 52) {
				player.remove(0);
				continue;
			}
			if(isOccupied(next)||next>52) {
				continue;
			}
			if(isPrime(next)) {
				next = movePrime(next);
			}
			else if(isSquare(next)) {
				next = moveSquare(next);
			}
			else if(isRule9(cur, next)) {
				next = moveRule9(cur, next, die);
			}
			player.set(0, next);
		}
    Collections.sort(player);
		System.out.println(player);
			
	}
		static boolean isPrime(int n){
		    
		    for(int i = 2; i <= n/2; i++) {
				if(n % i == 0) return false;
		    }
		    return true;
		}

		static int movePrime(int n){

			for(int i=0; i<6; i++){
		       if(isOccupied(n+1)) return n;
		       n++;
		    }
		    
		    return n;
		}

		static boolean isOccupied(int n){
			reset();
		    if(occ.contains(n)) return true;
		    else return false;
		}

		static void reset(){
		 occ = new ArrayList<Integer>();
		 occ.addAll(0, op);
		 occ.addAll(0, player);
		 Collections.sort(occ); 
		}
		static int moveRule9(int c, int n, int d) {
			for (int i = n; i >= c; i--) {
				if (i % d == 0) {
					if (!isOccupied(i)) {
						n = i;
						return n;
					}
				}
			}
			return c;
	}

		static boolean isRule9(int c, int n) {
		int[] r = {7, 12, 17, 22, 27, 35, 40, 45, 50};
		for(int i = 0; i < 9; i++) {
			if(c < r[i] && n > r[i]) {
				return true;
			}
		}
		return false;
	}

		static int moveSquare(int n) {
			for(int i=0; i<6; i++){
			       if(isOccupied(n-1)) return n;
			       n--;
			    }
			    
			    return n;
			}


		static boolean isSquare(int n) {
			if(n <= 4) {
				return false;
			}
			if(Math.sqrt(n) == (int)(Math.sqrt(n))) {
				return true;
			}
		return false;
	}
}