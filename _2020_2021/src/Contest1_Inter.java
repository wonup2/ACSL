import java.util.*;

public class Contest1_Inter {

	static Scanner in;
	static int start, delta, rows;
	
	public static void main(String[] args) {
	
		in = new Scanner(System.in);
		
		for(int i=0; i<5; i++) solve();
		
	}
	
	static void solve() {
		
		start = Integer.parseInt(in.next(), 8);  //oct to dec
		delta = Integer.parseInt(in.next(), 8);	 //oct to dec
		rows = in.nextInt();

		int repeat = (rows-1)*rows/2 -1;

		start += (delta* repeat);
		
		String lastRow = "";
		for(int i=0; i<rows; i++) {
			start+=delta;
			lastRow+= Integer.toOctalString(start);
		}
		
		int ans = 0;
		for(int i=0; i<lastRow.length(); i++) 
			ans += lastRow.charAt(i) - '0';
		
		
		System.out.println(ans);
	}
}
