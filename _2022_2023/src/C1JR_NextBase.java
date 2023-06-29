import java.util.*;

public class C1JR_NextBase {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			
			int n = in.nextInt();
			int b = in.nextInt();
			int s = in.nextInt();

			System.out.println(findDigitSum(n, b, s));
		}
	}
	
	public static int findDigitSum(int num, int base, int start) {
		
		String ans = start+"";
		start = Integer.parseInt(ans, base);  // Computer number to Integer
		
		for(int i=0; i<num-1; i++) {
			start++;
			ans += Integer.toString(start, base);   // Integer to Computer number
		}
		
		int ret = 0;
		for(int i=0; i<ans.length(); i++)
			ret+=ans.charAt(i)-'0';
				
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
