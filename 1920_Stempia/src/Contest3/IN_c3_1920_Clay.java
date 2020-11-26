package Contest3;
//Clay Shin | 10th Grade | Team Stempia | Intermediate 5 Contest 3

import java.util.*;
import java.io.*;
public class IN_c3_1920_Clay {
	static String[][] x = {{"*A*B~C~D", "*A*B*C~D", "~A*B*C~D", "~A*B~C~D"},
						   {"*A*B~C*D", "*A*B*C*D", "~A*B*C*D", "~A*B~C*D"},
						   {"*A~B~C*D", "*A~B*C*D", "~A~B*C*D", "~A~B~C*D"},
						   {"*A~B~C~D", "*A~B*C~D", "~A~B*C~D", "~A~B~C~D"}};
	static String s;
	static Scanner in;
	static String a[];
	static int t[][];
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920c3in.in"));
		for(int i = 0; i<5; i++) {
			try {
				init();
				solve();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	static void init() {
		s = in.nextLine();
		a = s.replace("+", " ").split(" ");
		for(int i = 0; i<a.length; i++) {
			a[i] = conv(a[i]);
		}
		t = new int[4][4];
	}
	static void solve() {
		for(int r = 0; r<4; r++) {
			for(int c = 0; c<4; c++) {
				String s = x[r][c];
				for(int i = 0; i<a.length; i++) {
					String temp = a[i];
					boolean okay = true;
					for(int j = 0; j<temp.length(); j+=2) {
						String pair = temp.substring(j, j+2);
						if(!s.contains(pair))
							okay = false;
					}
					if(okay) {
						t[r][c]=1;
						break;
					}
				}
			}
		}
		String ans = "";
		for(int i = 0; i<4; i++) {
			ans+=toHex(t[i]);
		}
		System.out.println(ans);
	}
	static String conv(String s) {
		String ans = "";
		for(int i = 0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c!='~')
				ans+="*"+c;
			else {
				ans+="~" + s.charAt(i+1);
				i++;
			}
		}
		return ans;
	}
	static String toHex(int[] y) {
		String temp = "" + y[0] + y[1] + y[2] + y[3];
		if(temp.equals("0000"))
			return "0";
		else if(temp.equals("0001"))
			return "1";
		else if(temp.equals("0010"))
			return "2";
		else if(temp.equals("0011"))
			return "3";
		else if(temp.equals("0100"))
			return "4";
		else if(temp.equals("0101"))
			return "5";
		else if(temp.equals("0110"))
			return "6";
		else if(temp.equals("0111"))
			return "7";
		else if(temp.equals("1000"))
			return "8";
		else if(temp.equals("1001"))
			return "9";
		else if(temp.equals("1010"))
			return "A";
		else if(temp.equals("1011"))
			return "B";
		else if(temp.equals("1100"))
			return "C";
		else if(temp.equals("1101"))
			return "D";
		else if(temp.equals("1110"))
			return "E";
		else
			return "F";
	}
}