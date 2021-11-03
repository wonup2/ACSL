import java.util.*;
import java.io.*;

public class CSES1083 {

	//static Scanner in;
	static BufferedReader in;
	//static StringBuilder sb;
	static long n, sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
	}

	static void init() throws NumberFormatException, IOException {
		n = Integer.parseInt(in.readLine());
		sum = n*(n+1)/2;  //<-------------------- 1+2+3+......+n
		n--;
	}
	
	static void solve() throws IOException {
		
		StringTokenizer st = new StringTokenizer(in.readLine());  //<---
		
		for(int i=0; i<n; i++) 			
			sum -= Integer.parseInt(st.nextToken());
		
		
		System.out.println(sum);
	}
}
