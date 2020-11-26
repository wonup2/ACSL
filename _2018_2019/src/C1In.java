import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class C1In {

	static Scanner in;
	static String N;
	static int P;
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("C1in.in"));
		for(int i = 0; i<5; i++) {
			init();
			solve();
		}
		in.close();
	}
	static void init() {
		N = in.next();
		P = in.nextInt();
	}
	static void solve() {
				
		BigInteger sum = new BigInteger("0");
		
		for(int i=0; i<=N.length()-P; i++) {			
			BigInteger num = new BigInteger(N.substring(i, i+P));
			sum = sum.add(num);
		}	
		
		System.out.println(sum);		
	}
}
