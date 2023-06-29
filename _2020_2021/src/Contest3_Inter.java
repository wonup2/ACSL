import java.util.*;

public class Contest3_Inter {

	static int[][] makeArray(String s, int[][] t) {
		
		String temp[] = s.split(" ");
		
		int idx =0;
		for(int i=0; i<t.length; i++) {
			for(int j = 0; j<t[0].length; j++) {
				t[i][j] = Integer.parseInt(temp[idx]);
				idx++;
			}
		}		
		return t;
	}

	static int cx, cy;
	static int[][] a, b, c;
	static int mutipleArrays(int n, int m, String x, String y, String z) {
		
		//make 2d array a, b, c
		a = new int[n][m];
		a = makeArray(x, a);
			
		b = new int[n][m];
		b = makeArray(y, b);
		
		c = new int[n][m];
		c = makeArray(z, c);

		int sum = 0;
		while(true) {
			sum+=smallest(); 
			
			if(cx>=n-1 || cy>=m-1) break;
			nextp();
		}
				
		return sum;
	}

	static void nextp() {
		int maxr = Math.max(Math.max(a[cx][cy+1], b[cx][cy+1]), c[cx][cy+1]);
		int maxd = Math.max(Math.max(a[cx+1][cy], b[cx+1][cy]), c[cx+1][cy]);
		int temp[] = {a[cx][cy+1], b[cx][cy+1], c[cx][cy+1],a[cx+1][cy], b[cx+1][cy], c[cx+1][cy]}; 
		
		int cnt=0;
		int max = Math.max(maxr, maxd);

		for(int i=0; i<temp.length; i++) 
			if(temp[i]==max) cnt++;
				
		if(cnt>1) {
			cx++;
			cy++;
		}
		else if(maxr > maxd) cy++;		
		
		else cx++;		
	}
	
	static int smallest() {
		return Math.min(Math.min(a[cx][cy], b[cx][cy]), c[cx][cy]);
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		for(int i=0; i<1; i++) {
			int n = in.nextInt();
			int m = in.nextInt(); in.nextLine();
			
			String a = in.nextLine();
			String b = in.nextLine();
			String c = in.nextLine();
		
			int result = mutipleArrays(n, m, a, b, c);
		
			System.out.println(result);
		}
	}
}

/*

3 4
1 2 3 4 7 7 8 9 5 6 7 8
6 8 6 4 4 5 3 2 8 3 1 9
3 6 7 3 4 6 2 1 3 2 5 5

6


4 2 
31 17 24 19 15 29 22 26
25 13 25 18 19 27 19 13
12 15 17 18 29 16 25 20

60


4 5 
3 1 4 1 5 9 2 6 5 3 5 8 9 7 9 3 2 3 8 4
6 2 6 4 3 3 8 3 2 7 7 2 3 8 3 3 4 6 2 6
5 8 3 2 3 9 7 9 8 5 3 5 6 2 9 5 1 4 1 3

16

*/