import java.util.Arrays;

public class Testtesttest {

	public static void main(String[] args) {

		int n = 4;
		int[] a = {1, 2, 3, 4};
		int[] b = new int[n];
		int[] c = new int[n];
		
		int p = 1;
		for(int i=0; i<n; i++) {
			b[i] = p;
			p *= a[i];
		}
		
		System.out.println(Arrays.toString(b));
		
		p = 1;
		for(int i=n-1; i>=0; i--) {
			c[i] = p;
			p *= a[i];
		}
		
		System.out.println(Arrays.toString(c));

		for(int i=0; i<n; i++) {
			a[i] = b[i]*c[i];
		}
		
		System.out.println(Arrays.toString(a));

	}

}
