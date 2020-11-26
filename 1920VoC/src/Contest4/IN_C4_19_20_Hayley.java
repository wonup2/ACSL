package Contest4;

/*
 * name: Hayley Song
 * grade: 11th
 * team: Voice of Calling
 * date: 04/07/20
 * division: Intermediate 3
 */
import java.util.*;
import java.io.*;

public class IN_C4_19_20_Hayley {

	static Scanner in;
	static PrintWriter out;
	static ArrayList<Integer> o, p, d;
	static int n;
	static int[] square = { 9, 16, 25, 36, 49 };
	static int[] nine = { 7, 12, 17, 22, 27, 35, 40, 45, 50 };

	public static void main(String[] args) {
		try {
			in = new Scanner(new File("1920c4in.in"));
			out = new PrintWriter(new File("1920c4in.out"));
			for (int i = 0; i < 5; i++) {
				init();
				solve(i);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void init() {
		o = new ArrayList<Integer>(); // <---opponent
		p = new ArrayList<Integer>(); // <---player
		d = new ArrayList<Integer>(); // <---dice

		for (int i = 0; i < 3; i++)
			o.add(in.nextInt());
		for (int i = 0; i < 3; i++)
			p.add(in.nextInt());
		n = in.nextInt();
		for (int i = 0; i < n; i++)
			d.add(in.nextInt());

		Collections.sort(o);
		Collections.sort(p);

		// System.out.println(o);
		// System.out.println(p);
		// System.out.println(n);
		// System.out.println(d);
	}

	public static void solve(int i) {
		for (int die : d) {
			Collections.sort(p);
			int move = p.get(0) + die;
			// System.out.println("*" + move + " die: " + die);
			// System.out.println(p);

			if (move == 52) {
				p.remove(0);
				continue;
			}
			if (move > 52 || isOccupied(move))
				continue;

			if (isPrime(move))
				p.set(0, movePrime(move, move + 6));
			else if (isSquare(move))
				p.set(0, moveSquare(move, move - 6));
			else if (isRule9(p.get(0), move))
				p.set(0, moveRule9(p.get(0), move, die));
			else
				p.set(0, move);

			// System.out.println(p);
		}

		Collections.sort(p);
		System.out.println((i+1)+" :" + p); // <---- answer
	}

	/*
	 * make methods 0. isOccupied 1. isPrime, movePrime 2. isSquare, moveSquare 3.
	 * isRule9, moveRule9
	 */

	public static boolean isOccupied(int x) {
		if (o.contains(x))
			return true;
		if (p.contains(x))
			return true;
		return false;
	}

	public static boolean isPrime(int x) {
		for (int i = 2; i < x; i++) {
			if (x % i == 0)
				return false;
		}
		return true;
	}

	public static int movePrime(int x, int y) {
		int next = y;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.addAll(o);
		temp.addAll(p);
		Collections.sort(temp);
		// System.out.println(temp);
		for (int i : temp) {
			if (i > x && i <= y) {
				next = i - 1;
				// System.out.println("Prime: " + next);
				return next;
			}
		}
		/*
		 * for(int i : o) { if(i > x && i <= y) { next = i-1; System.out.println(next);
		 * return next; } } for(int i : p) { if(i > x && i <= y) { next = i-1;
		 * System.out.println(next); return next; } }
		 */
		// System.out.println("Prime: " + next);
		return next;
	}

	public static boolean isSquare(int x) {
		for (int i : square) {
			if (x == i)
				return true;
		}
		return false;
	}

	public static int moveSquare(int x, int y) { // 9 & 3
		int next = y;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.addAll(o);
		temp.addAll(p);
		Collections.sort(temp);
		// System.out.println(temp);
		for (int i = temp.size() - 1; i >= 0; i--) {
			if (temp.get(i) < x && temp.get(i) >= y) {
				next = temp.get(i) + 1;
				// System.out.println("Square: " + next);
				return next;
			}
		}
		/*
		 * for(int i : o) { if(i < x && i >= y) { next = i + 1;
		 * System.out.println(next); return next; } } for(int i : p) { if(i < x && i >=
		 * y) { next = i + 1; System.out.println(next); return next; } }
		 */
		// System.out.println("Square: " + next);
		return next;
	}

	public static boolean isRule9(int x, int y) { // 18 & 22
		for (int i : nine) {
			if (x < i && y > i) {
				return true;
			}
		}
		return false;
	}

	public static int moveRule9(int x, int y, int z) { // p.get(0), move, die
		for (int i = y; i >= x; i--) {
			if (i % z == 0) {
				if (!isOccupied(i)) {
					y = i;
					return y;
				}
			}
		}
		return x;
	}
}
/*37 41 47 35 43 48 6 5 5 6 5 4 2
13 29 39 15 21 31 10 4 5 2 4 6 6 5 5 6 5
43 47 40 28 30 32 10 5 3 2 6 1 5 2 6 3 2
1 5 10 2 12 8 12 5 5 4 4 3 3 2 2 1 1 6 6
20 25 15 30 18 24 16 6 6 4 5 2 1 6 4 2 3 6 5 4 5 3 1*/