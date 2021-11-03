package Stempia.contest1;
//Hyeonchae Kim
//ABCobot Intermediate 5
//Contest 1



import java.util.*;
import java.io.*;
	
public class IN_numberTrans_Hyeonchae {

	static Scanner in;
	static int P, num, index;
	static String N, temp, ans;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		in = new Scanner(new File("contest1.in"));
		
		for(int i = 0; i < 5; i++) {
	
			try {
			
				init();
				solve();
			
			}catch(Exception e){
			
				e.printStackTrace();
			
			}
			
		}
		
	}
	
	public static void init() {
		
		String[] temp = in.nextLine().split(" ");
		N = temp[0];
		P = Integer.parseInt(temp[1]);
	
		num = N.charAt(N.length() - P) - '0';
		index = N.length() - P;
		
		ans = "";
		
	}
	
	public static void solve() {
		
		for(int i = 0; i < index; i++) {
			
			int a = N.charAt(i) - '0' + num;
			
			if(a > 9)
				ans += a % 10;
			else
				ans += a;
			
		}
		
		ans += num;
		
		for(int i = index + 1; i < N.length(); i++) {
			
			int a = N.charAt(i) - '0' - num;
			
			if(a < 0)
				ans += 0 - a;
			else
				ans += a;
			
		}
		
		System.out.println(ans);
		
	}
	
}
