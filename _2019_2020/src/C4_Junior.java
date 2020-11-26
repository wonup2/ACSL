import java.util.*;
import java.io.*;

public class C4_Junior {
	static Scanner in;
	static ArrayList<Integer> o,d;
	static int n, m;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920c4jr.in"));

		for(int i=0; i<1; i++) {
			init();
			solve();
		}
	}
	
	static void init() throws IOException{
		o=new ArrayList<Integer>();
		d=new ArrayList<Integer>();
	
		for(int i=0; i<3; i++) o.add(in.nextInt());
		m = in.nextInt();
		n = in.nextInt();
		for(int i=0; i<n; i++) d.add(in.nextInt());
		Collections.sort(o);
		System.out.println(o+" "+m+" "+d);
	}
	
	static void solve() {
		for(int die:d) {			
			int move = m + die;															System.out.print("\n"+m+" + "+die+" = "+move);					
			
			if(move==52) { System.out.println("GAME OVER"); return;}
			if(move>52 || o.contains(move)) {System.out.print("\toccupied "+m);	continue;}
			
			if(isPrime(move)) {m=movePrime(move, move+6);								System.out.print("\tprime "+m);}			
			else if(isSquare(move)) {m=moveSquare(move, move-6);						System.out.print("\tsquare "+m);}
			else if(isRule9(m, move)) {m= moveRule9(m, move, die); 						System.out.print("\trule9 "+m);}	
			else { m= move; 															System.out.print("\tnoRule "+m);}
		}
		
		System.out.println("\n" +m);
	}
	
	static boolean isPrime(int num) {
		for(int i=2; i<=num/2; i++)
			if(num%i==0) return false;
		return true;
	}
	
	static int movePrime(int n1, int n2) {
		for(int i:o)
			if(n1<i && i<=n2) return i-1;					
		return n2;
	}
	
	static boolean isSquare(int num) {
		return num>4 && Math.sqrt(num)==(int)Math.sqrt(num);
	}
	
	static int moveSquare(int n1, int n2) {  
		for(int i=o.size()-1; i>=0; i--)
			if(n1>o.get(i) && o.get(i)>=n2) return o.get(i)+1;		
		return n2;
	}
	
	static boolean isRule9(int n1, int n2) {
		int[] r = {7, 12, 17, 22, 27, 35, 40, 45, 50};
		for(int i=0; i<9; i++)
			if(n1 < r[i] && n2 > r[i]) return true;
		return false;				
	}
	
	static int moveRule9(int n, int n1, int n2) {
		while(n1>=n2) {
			if(n1%n2==0) {
				if(o.contains(n1)) return n;
				else return n1;
			}
			n1--;
		}
		return n1;
	}
}
