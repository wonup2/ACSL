import java.util.*;

public class C1IN_NextBase {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			
			int n = in.nextInt();
			int b = in.nextInt();
			int s = Integer.parseInt(in.next(), b);
			
			int result = solve(n, b, s);
			System.out.println(result);
		}
	}
	
	static int solve(int n, int b, int s) {
		
		String ans = "";
		
		for(int i=0; i<n; i++) {
			ans += Integer.toString(s, b);
			s++;
		}

		int ret = 0;
		for(int i=0; i<ans.length(); i++)
			if(ans.charAt(i)-'0' == (b-1)) ret++;
				
		return ret;
	}
}

/*

1000 8 10
50 4 13
75 9 384
100 6 555
25 2 1100001110

*/
