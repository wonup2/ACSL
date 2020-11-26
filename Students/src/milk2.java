import java.io.*;
import java.util.*;

public class milk2 {

	static pair a[];
	static Scanner in;
	static PrintWriter out;
	static int N;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("milk2.in"));
		out = new PrintWriter(new File("milk2.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		N = in.nextInt();
		a = new pair[N];
		
		for(int i=0; i<3; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			a[i] = new pair(x, y);
		}			
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
	static void solve() {
		
	}
	
	static class pair implements Comparable<pair>{
		int start;
		int end;
		
		pair(int s, int e){
			this.start = s;
			this.end = e;
		}
		
		public String toString() {
			return start + " " + end;
		}

		@Override
		public int compareTo(pair that) {
		
			if (this.start < that.start) return -1;
			else if (this.start > that.start) return 1;
			else {
				if( this.end < that.end ) return -1;
				else return 1;
			}
		}
	}
}
