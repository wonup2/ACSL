import java.util.*;
import java.io.*;

public class C4_Intermediate {
	static Scanner in;
	static ArrayList<Integer> o,p,d,t;
	static int n;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920c4in.in"));

		for(int i=0; i<1; i++) {
			init();
			solve();
		}
	}

	static void init() throws IOException{
		o=new ArrayList<Integer>();
		p=new ArrayList<Integer>();
		d=new ArrayList<Integer>();
	
		for(int i=0; i<3; i++) o.add(in.nextInt());
		for(int i=0; i<3; i++) p.add(in.nextInt());
		n = in.nextInt();
		for(int i=0; i<n; i++) d.add(in.nextInt());
		
		Collections.sort(o);
		Collections.sort(p);
																					System.out.println(o+" "+p+" "+d);
	}
	
	static void solve() {
		for(int die:d) {
			Collections.sort(p);													System.out.println(p);
			
			int move = p.get(0)+die;												System.out.print(p.get(0)+"+"+die+"="+move+"\t");
			
			if(move==52) { p.remove(0); continue;}
			if(move>52 || isOccupied(move)) {	System.out.println(t+"\toccupied "+p.get(0));	 continue;}
			
			if(isPrime(move)) {p.set(0, movePrime(move, move+6));						System.out.println(t+"\tprime "+p.get(0));}			
			else if(isSquare(move)) {p.set(0, moveSquare(move, move-6));				System.out.println(t+"\tSquare "+p.get(0));}
			else if(isRule9(p.get(0), move)) {p.set(0, moveRule9(p.get(0), move, die)); System.out.println(t+"\tRule9 "+p.get(0));}	
			else {p.set(0, move); 														System.out.println(t+"\tnoRule "+p.get(0));}
		}
		
		Collections.sort(p);
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
		for(int i=t.size()-1; i>=0; i--)
			if(n1>t.get(i) && t.get(i)>=n2) return t.get(i)+1;		
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
		t=new ArrayList<Integer>();
		for(int i=0; i<p.size(); i++) t.add(p.get(i));
		for(int i=0; i<o.size(); i++) t.add(o.get(i));
		Collections.sort(t);
	}
}
