//2019-2020 Contest 1 Junior
package Contest1;

import java.util.*;
import java.io.*;

public class JR_NumberTransformation_Minjun {

	static Scanner in;
	static PrintWriter out;
	static String n;
	static int p, d, z;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("1920c1Jr.in"));
			out = new PrintWriter(new File("1920Jr.out"));
			
			for(int i = 0; i < 5; i++ ) {
				init();
				solve();
				System.out.println(n);
			}
			
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		n = in.next();
		p = in.nextInt();
		d = in.nextInt();
		z = p-1;
	}
	
	private static void solve() {
		int temp = Integer.parseInt(n.substring(n.length()-p, n.length()-p+1));
		if(temp >= 0 && temp <=4) {
			temp += d;
			temp = Integer.parseInt(Integer.toString(temp).substring(Integer.toString(temp).length()-1));
			n = n.substring(0, n.length()-p);
			n += Integer.toString(temp);
			for(int i = 0; i < z; i++) {
				n += "0";
			}
		}
		else {
			temp = Math.abs(temp - d);

			if(Integer.toString(temp).length() > 1) {
				temp = Integer.parseInt(Integer.toString(temp).substring(0,1));
			}
			n = n.substring(0, n.length()-p);
			n += Integer.toString(temp);
			for(int i = 0; i < z; i++) {
				n += "0";
			}
		}		
	}
}
