package Contest4;
/*
 * Joshua Nam
 * Grade 10
 * STEMPIA
 * Intermediate
 * Contest 4
 */
import java.util.*;
import java.io.*;
public class IN_Patolli_Joshua  {
	static Scanner in;
	static int n, low;
	static ArrayList<Integer> player, rolls, taken;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new Scanner(new File("1920C4IN.in"));
		for(int i = 0; i < 5; i++) {
			init();
			solve();
		}
		in.close();
	}
	
	private static void init() throws IOException{
		player = new ArrayList<Integer>(); rolls = new ArrayList<Integer>(); taken = new ArrayList<Integer>();
		for(int i = 0; i < 3; i++)
			taken.add(in.nextInt());
		for(int i = 0; i < 3; i++) {
			int a = in.nextInt();
			player.add(a); taken.add(a);
		}
		n = in.nextInt();
		for(int i = 0; i < n; i++) {
			rolls.add(in.nextInt());
		}
	}
	
	private static void solve() throws IOException{
		for(int i = 0; i < n; i++) {
			Collections.sort(player);
			low = player.get(0);
			if(taken.indexOf(player.get(0)) != -1)
				taken.remove(taken.indexOf(low));
			int moves = rolls.get(i);
			if(rule4(moves)) {
				if(low + moves == 52) {
					player.remove(0);
					continue;
				}
				else if(low + moves < 52) {
					low = low + moves;
					if(isPrime(low)) 
						rule7(moves);
					else if(isSquare(low))
						rule8(moves);
					else if(cond9(moves))
						rule9(moves);
					player.set(0, low);
					taken.add(low);
				}
				else
					continue;
			}
		}
		Collections.sort(player);
		if(player.size() == 0)
			System.out.println("GAME OVER");
		else {
			for(int i = 0; i < player.size(); i++)
				System.out.print(player.get(i) + " ");
			System.out.println();
		}
	}
	
	private static boolean rule4(int moves) {
		for(int i = 0; i < taken.size(); i++) {
			if(low + moves == taken.get(i))
				return false;
		}
		return true;
	}

	private static boolean isPrime(int num) {
		   if (num <= 1) 
		       return false;
		   for (int i = 2; i <= Math.sqrt(num); i++) {
		       if (num % i == 0) {
		           return false;
		       }
		   }
		   return true;
	}

	private static boolean isSquare(int n) {
		int round = (int)Math.sqrt(n);
		if(Math.pow(round, 2) == n)
			return true;
		else
			return false;
	}
	
	public static boolean cond9(int moves) {
		int a = low - moves;
		int loc = low;
		if(((a >= 3 && a <= 6) && loc > 7) || ((a >= 7 && a <= 11) && loc > 12) || ((a >= 12 && a <= 16) && loc > 17) || ((a >= 17 && a <= 21) && loc > 22) || 
		   ((a >= 22 && a <= 26) && loc > 27) || ((a >= 27 && a <= 34) && loc > 35) || ((a >= 35 && a <= 39) && loc > 40) || ((a >= 40 && a <= 44) && loc > 45) || ((a >= 45 && a <= 49) && loc > 50)) {
			return true;
		}
		return false;
	}
	
	private static void rule7(int moves) {
		//System.out.println("prime");
		boolean a = false;
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < taken.size(); j++) {
				if(low + 1 == taken.get(j)) {
					a = true;
					break;
				}
			}
			if(a)
				break;
			low++;
		}
	}

	private static void rule8(int moves) {
		boolean a = false;
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < taken.size(); j++) {
				if(low - 1 == taken.get(j)) {
					a = true;
					break;
				}
			}
			if(a)
				break;
			low--;
		}
	}

	private static void rule9(int moves) {
		if(low % moves == 0)
			return;
		int min = low - moves;
		boolean a = false;
		for(int i = 1; i < 30; i++) {
			int temp = i * moves;
			for(int j = 0; j < taken.size(); j++) {
				if(temp >= min && temp <= low && taken.get(j) == temp) {
					a = false;
					break;
				}
				if(temp >= min && temp <= low && taken.get(j) != temp) {
					a = true;
				}
			}
			if(a) {
				low = temp;
				break;
			}
		}
		if(a == false)
			low = low-moves;
	}

}
/*
4 14 24 1 8 12 6 6 3 5 1 5 6
14 28 31 10 20 24 7 6 6 5 5 6 2 4
5 30 33 3 20 24 8 6 6 6 5 6 3 4 6
4 11 15 2 8 20 5 5 2 5 1 6
45 50 48 42 46 40 6 3 2 6 5 4 1
*/