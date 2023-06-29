import java.util.*;

public class C2_IN_FibonacciCypher {

	static Scanner in;
	static int fibo[], key;
	static String line;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void init() {
		
		fibo = new int[20];
		fibo[0] = in.nextInt();
		fibo[1] = in.nextInt();
		for(int i=2; i<20; i++) fibo[i]=fibo[i-1]+fibo[i-2];
		
		key = in.next().charAt(0);
		line = in.nextLine().trim();
	}
	
	static void solve() {
		
		int j=0;
		for(int i=0; i<line.length(); i++) {
			
			if(j==20) j=0;

			if(fibo[j]>26) fibo[j]%=26;
			if(fibo[j]==0) fibo[j]=26;
			
			int offset = key + fibo[j++];
			
			if(offset>'z')offset-=26;
			
			offset*=3;
			
			System.out.print(line.charAt(i)+offset +" ");

		}
	}

}

//2 5 a Fibonacci Numbers are found in many places including the Mandelbrot Set.
//11 13 q The ratio of 2 adjacent Fibonacci numbers in the sequence approaches the Golden number, phi, which is approx. 1.618...
