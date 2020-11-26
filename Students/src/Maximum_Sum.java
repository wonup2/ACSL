import java.util.*;
public class Maximum_Sum {
	static Scanner in;
	static int n;
	static int[] a;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		n = in.nextInt();
		a = new int[n];
		for(int i = 0;i<a.length;i++) {
			a[i] = in.nextInt();
		}
		int sum = 0;
		for(int i =0;i<a.length;i++) {
			sum+=a[i];
		}
		System.out.println(sum);
	}
}

/*
4
1
2
-3
4
*/