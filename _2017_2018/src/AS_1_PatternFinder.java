import java.io.*;
import java.util.*;

public class AS_1_PatternFinder {

	static char[][] a, b;
	static Scanner in;
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("as1-sample.txt"));
		
		init();
		
		for(int i=0; i<10; i++) {
			init1();
			solve();
		}
	}

	
	static void init() {
		a = new char[8][8];
		for(int i=0; i<8; i++) {
			int n = Integer.parseInt(in.next(), 16);
			String s = Integer.toBinaryString(n);
			while(s.length()<8) {
				s='0'+s;
			}
			a[i] = s.toCharArray();
		}
		
		//System.out.println(Arrays.deepToString(a));	
	}
	
	
	static void init1() {
		int r = in.nextInt();
		int c = in.nextInt();
		System.out.println(r+" "+c);
		b=new char[r][c];
		for(int i=0; i<r; i++)
			b[i] = in.next().toCharArray();
		
		
		System.out.println(Arrays.deepToString(b));
	}
	
	
	
	static void solve() {

		
		

			
	}
}




