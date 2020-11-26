package Contest1;
/*
Hayley Song
11th grade
Voice of Calling
Contest 1 Intermediate 3
*/




import java.util.*;
import java.io.*;

public class IN_NumberTransformation_Hayley {

	static Scanner in;
	static int P;
	static String N;
	static String[] num;

	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920c1in.in"));
		for (int i = 0; i < 5; i++) {
			try {
				init();
				solve();
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("Error");
			}
		}
		in.close();
	}

	private static void init() {
		num = in.nextLine().split(" ");
		N = num[0];
		P = Integer.parseInt(num[1]);
	}

	private static void solve() {
		String ans = "";
		int place = N.length() - P;
		int multi = Integer.parseInt(N.charAt(place) + "");
		for (int i = 0; i < N.length(); i++) {
			if (i == place) {
				ans += Integer.parseInt(N.charAt(i) + "");
			}
			if (i < place) {
				if (Integer.parseInt(N.charAt(i) + "") + multi > 9)
					ans += (Integer.parseInt(N.charAt(i) + "") + multi) % 10;
				else
					ans += Integer.parseInt(N.charAt(i) + "") + multi;
			}
			if (i > place) {
				ans += Math.abs(Integer.parseInt(N.charAt(i) + "") - multi);
			}
		}
		System.out.println(ans);

	}

}
