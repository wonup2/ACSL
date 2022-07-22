import java.util.*;
public class prefixSum {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) a[i] = in.nextInt();
		
		int[] p = new int[a.length];
		
		p[0] = a[0];
		for(int i=1; i<a.length; i++)
			p[i] = p[i-1] + a[i];
		
		
		int m = in.nextInt();
		
		for(int  i=0; i<m; i++) {
			int s = in.nextInt();
			int e = in.nextInt();
			int sum = p[e] - p[s-1];
			
			System.out.println(sum);	
		}
	}
}

/*

7
1 3 5 7 2 10 34
5
2 4
4 6
1 5
2 3
3 5

*/
