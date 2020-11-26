package Contest4;
import java.io.File;
import java.io.IOException;
import java.util.*;
/*
Mincheol Song
Grade 9
Team Voice of Calling Junior 5
*/
public class C4_jr_Mincheol {
	
	static Scanner in;
	static ArrayList<Integer> o;
	static int p;
	static ArrayList<Integer> d;
	static int a;
	static int[] prime = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};
	static int[] square = {9,16,25,36,49};
	static int[] rule9 = {7,12,17,22,27,35,40,45,50};
	public static void main(String[] args)throws IOException {
		in = new Scanner(new File("1920C4jr.in"));
		for(int i =0; i<5; i++) {
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
	private static void init() {
		o = new ArrayList<Integer>();
		d = new ArrayList<Integer>();
		
		for(int i=0; i<3; i++) o.add(in.nextInt());
		p = in.nextInt();
		a = in.nextInt();
		for(int i =0; i<a; i++) d.add(in.nextInt());
		
		Collections.sort(o);
	}
	private static void solve() {
		boolean check = false;
		for(int i:d) {
			
			//step1
			int marker = p+i;
			if(marker>52||isOccupied(marker)) { marker = p;}
			if(marker==52) {check = true; break;}
		
			//step
			if(isPrime(marker)) {
				p = mPrime(marker);
				
				
				
			}
			else if(isSquare(marker)) {
				p = mSquare(marker);
				
				
			}
			
			else if(isRule9(p, marker)) {
			
				p = mRule9(p, marker, i);
				
				
			
			}
			else {
				p = marker;
				
			}
			
		}
		if(check) System.out.println("GAME OVER");
			else System.out.println(p);
		
	}
	private static boolean isOccupied(int a) {
		for(int i =0; i<3; i++) {
			if(a == o.get(i)) {
				return true;
			}
		}
		return false;
	}
	private static boolean isPrime(int a) {
		boolean c = false;
		for(int i=0; i<prime.length; i++) {
			if(prime[i] == a) {
				c = true;
			}
		}
		return c;
	}
	private static boolean isSquare(int a) {
		boolean c = false;
		for(int i=0; i<square.length; i++) {
			if(square[i] == a) {
				c = true;
			}
		
		}
		
		return c;
	}
	private static boolean isRule9(int a ,int b) {
		for(int i =0; i<rule9.length;i++) {
			if(a<rule9[i]&&b>rule9[i]) {
				return true;
			}
		}
		return false;
	}
	private static int mPrime(int a) {
	        for(int i =a+1; i<=a+6; i++) {
	            if(isOccupied(i)) return i-1;
	           
	        }
	       return a+6;
	    }
	private static int mSquare(int a) {
		 for(int i =a-1; i>=a-6; i--) {
	            if(isOccupied(i)) return i+1;
	           
	        }
	       return a-6;
	}
	
	private static int mRule9(int a, int b,  int c) {
		for(int j = b; j>=a; j--) {
			if(j%c==0) {
				if(!isOccupied(j)) {
					b = j;
					return b;
				}
			}
		}
		
		
		return a;
	}
	
	
}
