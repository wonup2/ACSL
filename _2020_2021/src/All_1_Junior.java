import java.util.*;


public class All_1_Junior {

	static Scanner in;
	static int n, m, a[][];
	
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		
		for(int i=0; i<1; i++) {
			init();
			solve();
		}
	}

	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		
		a = new int[n][m];
		for(int i=0; i<n; i++) 
			for(int j=0; j<m; j++) 
				a[i][j] = in.nextInt();		
	}	
	
	static void solve() {
		
		int ans = Integer.MIN_VALUE;
		
		for(int r1=0; r1<n; r1++) {
			for(int r2=r1; r2<n; r2++) {
				
				for(int c1=0; c1<m; c1++) {
					for(int c2=c1; c2<m; c2++) {		
						
						int sum=0;
						for(int i=r1; i<=r2; i++) {
							for(int j=c1; j<=c2; j++) {								
								sum += a[i][j];
							}
						}
						ans = Math.max(ans, sum);
					}
				}
			}
		}
		System.out.println(ans);
	}
}
