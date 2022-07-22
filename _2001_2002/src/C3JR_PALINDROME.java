import java.util.LinkedList;
import java.util.Scanner;

public class C3JR_PALINDROME {

	static Scanner in;
	static int n, sum;
	static String s1, s2;
	static StringBuilder sb;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		
		init();
		solve();
	}
	
	static void init() {
		
		s1 = in.next();
		s2 = new StringBuilder(s1).reverse().toString();
	}

	static void solve() {
				
		while(!s1.equals(s2)&& sum<=2000000){
			
			//System.out.println(s1 + " "+s2 );
			s1 = Long.parseLong(s1)+Integer.parseInt(s2) + "";	
			s2 = new StringBuilder(s1).reverse().toString();
		}
		System.out.println(s1);
	}
}

