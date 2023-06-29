//ACSL All-Stars Contest 2015 4

import java.util.*;

public class AS15_4_Detect {
	static int num1 = 0;
	static int add = 0;
	static String mask = "";
	static String answer = "";
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		for(int x=0; x<10; x++) {
			
			String[] t2 = (in.nextLine()).split(", ");
			
			num1 = Integer.parseInt(t2[1]);
			
			add = Integer.parseInt(t2[2]);
			
			mask = t2[0];
			
			r(t2[0].length(), "");
			
			System.out.print((x+1)+". ");
			
			if(answer.length()<=0) System.out.println("NONE");
			else System.out.println(answer.substring(0, answer.length()-2));
			
			answer = "";
		}
	}
	
	static void check(String s) {
		
		int ones = 0;
		
		int total = 0;
		
		for(int x=0; x<mask.length(); x++) {
			
			if(s.charAt(x)=='1') {
				ones++;
				total += Integer.parseInt(""+mask.charAt(x));
			}
		}
		
		if(ones != num1) return;
		
		if(total == add)answer += (s+", ");
		
	}
	
	static void r(int i, String s) {
		
		if(i==0) check(s);
		else {
			r(i-1, s+"0");
			r(i-1, s+"1");
		}
	}
	
}