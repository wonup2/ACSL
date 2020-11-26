import java.util.*;
import java.io.*;

public class Vestigium {

	static Scanner in;
	static int t, n, a[][], x;
	static ArrayList<Integer> temp = new ArrayList<Integer>();

	public static void main(String[] args) {
		in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		try {
			t = in.nextInt();
			for (x = 1; x <= t; x++) {
				init();
				solve();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void init() {
		n = in.nextInt();
		a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = in.nextInt();
			}
		}
	}

	public static void solve() {
		int k = 0;
		for (int i = 0; i < n; i++) {
			k += a[i][i];
		}
		int r = 0;
		for(int i = 0; i < n; i++) {
			temp.clear();
			for(int j = 0; j < n; j++) {
				if(!temp.contains(a[i][j])) {
					temp.add(a[i][j]);
				}else {
					r+=1;
					break;
				}
			}
		}
		int c = 0;
		for(int i = 0; i < n; i++) {
			temp.clear();
			for(int j = 0; j < n; j++) {
				if(!temp.contains(a[j][i])) {
					temp.add(a[j][i]);
				}else {
					c+=1;
					break;
				}
			}
		}
		System.out.println("Case #" + x + " : " + k + " " + r + " " + c);
	}
}
/*
 3
 4
 1 2 3 4
 2 1 4 3
 3 4 1 2
 4 3 2 1
 4
 2 2 2 2
 2 3 2 3
 2 2 2 3
 2 2 2 2
 3
 2 1 3
 1 3 2
 1 2 3
 */