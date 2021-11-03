import java.math.BigInteger;
import java.util.*;

public class Contest1_Inter {

	static Scanner in;
	static int start, delta, rows, a[][];
	
	public static void main(String[] args) {
	
		in = new Scanner(System.in);
		init();
		solve();
		
	}

	static void init() {
		start = in.nextInt();
		delta = in.nextInt();
		rows = in.nextInt();
		a = new int[rows][];
	}

	static void solve() {		

		for(int i=0; i<rows; i++) {
			a[i] = new int[i+1];
			for(int j=0; j<=i; j++) {
				a[i][j] = start;
				start+=delta;
			}
		}
		
		//System.out.println(Arrays.deepToString(a));
		
		String ans = calculate(a[rows-1]);
		
		System.out.println(ans);
	}
	
	static String calculate(int[]a) {
		BigInteger ans = new BigInteger("0");
		for(int i=0; i<a.length; i++) {
			String temp = Integer.toString(a[i], 8);

			int sum=0;
			
			for(int j=0; j<temp.length(); j++) 
				sum+= temp.charAt(j)-'0';
			
			ans = ans.add(BigInteger.valueOf(sum));			
		}
		
		return ans.toString();
	}
}
