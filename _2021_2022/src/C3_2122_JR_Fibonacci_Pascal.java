import java.util.*;

public class C3_2122_JR_Fibonacci_Pascal {

	static Scanner in;
	static int t = 5, row = 5;
	static int n, a[][];
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		a = new int[row][1];
		
		a[0][0] = 1;
		
		for(int i=1; i<row; i++) {
			a[i] = new int[i+1];
			a[i][0] = 1;
			for(int j=1; j<a[i].length-1; j++) {
				a[i][j] = a[i-1][j-1]+a[i-1][j];
			}
			a[i][i]=1;
		}
		
		System.out.println(Arrays.deepToString(a));
	}

}
