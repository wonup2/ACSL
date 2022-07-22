import java.util.*;
import java.io.*;
public class CSES1646 {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, q;
	static long a[];
	
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();

	}
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		a = new long[n+1];
		
		st = new StringTokenizer(in.readLine());
		for(int i=1; i<=n; i++) {
			a[i] = Long.parseLong(st.nextToken());
			a[i] += a[i-1];
		}		
	}

	static void solve() throws IOException {
		long sum = 0l;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			sum = a[e] - a[s-1];
			sb.append(sum).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
