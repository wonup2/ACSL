import java.util.*;
import java.io.*;

public class C4_Senior {
	static Scanner in;
	static TreeSet<Integer> o,p,d,t;
	static int n;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920c4in.in"));

		for(int i=0; i<1; i++) {
			init();
			solve();
		}
	}

	static void init() throws IOException{
		o=new TreeSet<Integer>();
		p=new TreeSet<Integer>();
		d=new TreeSet<Integer>();
	
		for(int i=0; i<3; i++) o.add(in.nextInt());
		for(int i=0; i<3; i++) p.add(in.nextInt());
		n = in.nextInt();
		for(int i=0; i<n; i++) d.add(in.nextInt());

		System.out.println(o+" "+p+" "+d);
	}
	
	static void solve() {
		for(int die:d) {
			
			int move = p.first()+die;				System.out.print(p.first()+"+"+die+"="+move+"\t");
			
			if(move==52) { 
				p.remove(0); 
				continue;
			}
			if(move>52 || isOccupied(move)) {		System.out.println(t+"\toccupied "+p.first());	 
				continue;
			}
			
			if(isPrime(move)) { 					System.out.println(t+"\tSquare "+p.first());
				p.remove(0); 
				p.add(movePrime(move, move+6));
			}			
			else if(isSquare(move)) { 				System.out.println(t+"\tSquare "+p.first());
				p.remove(0); 
				p.add(moveSquare(move, move-6));
			}
			else if(isRule9(p.first(), move)) {		System.out.println(t+"\tRule9 "+p.first());
				p.add(moveRule9(p.first(), move, die)); 
			}	
			else {									System.out.println(t+"\tnoRule "+p.first());
				p.add(move);
			}
		}
				
		System.out.println("ans :" +p+"\n");
	}
	
	static boolean isPrime(int num) {
		for(int i=2; i<=num/2; i++)
			if(num%i==0) return false;
		return true;
	}
	
	static int movePrime(int n1, int n2) {
		for(int i:t)
			if(n1<i && i<=n2) return i-1;					
		return n2;
	}
	
	static boolean isSquare(int num) {
		return num>4 && Math.sqrt(num)==(int)Math.sqrt(num);
	}
	
	static int moveSquare(int n1, int n2) {  
		for(int i:t)
			if(n1>i && i>=n2) return i+1;		
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
				if(t.contains(n1)) return n;
				else return n1;
			}
			n1--;
		}
		return n1;
	}
	
	static boolean isOccupied(int num) {
		reset();
		return t.contains(num);
	}
	
	static void reset() {
		t=new TreeSet<Integer>();
		for(int i:p) t.add(i);
		for(int i:o) t.add(i);
	}
}
