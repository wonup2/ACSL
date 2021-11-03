import java.util.*;
import java.io.*;

public class CSES1068 {

	static Scanner in;
	//static BufferedReader in;
	static StringBuilder sb;
	static long n;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
	}

	static void init() {
		n = in.nextLong();
		sb = new StringBuilder();
		sb.append(n);
	}
	
	static void solve() {
		
		while(n!=1) {
			if(n % 2 == 1) n = n*3+1;
			else n/=2;
			
			sb.append(" ").append(n);
		}
		
		System.out.println(sb.toString());
	}
}
