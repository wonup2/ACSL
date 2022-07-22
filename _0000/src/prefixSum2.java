import java.util.*;
public class prefixSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		int [][]a = new int[n+1][m+1];
		
		for(int i = 1; i<n+1; i++) {
			for(int j = 1; j<m+1; j++) {
				a[i][j] = in.nextInt();
				a[i][j] += a[i-1][j]+a[i][j-1]-a[i-1][j-1];
			}
		}
		
		System.out.println(Arrays.deepToString(a));
		int q = in.nextInt();
		int sum = 0;
		for(int i=0; i<q; i++) {
			int rs = in.nextInt();
			int cs = in.nextInt();
			int re = in.nextInt();
			int ce = in.nextInt();
			
			sum = a[re][ce] - a[rs-1][ce] - a[re][cs-1] + a[rs-1][cs-1];
			System.out.println(sum);
		}
			
	}

}


/*
4 2 
1 2 -3 4 -5 6 7 -8
3
1 1 1 1
1 1 3 1
1 1 3 2
*/

