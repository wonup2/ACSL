/*
ID: wonup21
LANG: JAVA
TASK: namenum
*/


import java.util.*;
import java.io.*;
public class namenum {
	
	static BufferedReader in1;
	static BufferedReader in2;
	static PrintWriter out;
	
	static String number;
	static TreeSet<String> set;
	public static void main(String[] args)throws IOException {
		
		in1 = new BufferedReader(new FileReader("namenum.in"));
		in2 = new BufferedReader(new FileReader("dict.txt"));
		out = new PrintWriter(new File("namenum.out"));
		
		init();
		solve();
		
		in1.close();
		in2.close();
		out.close();

	}
	static void init() throws IOException {
		set = new TreeSet<String>();
		number = in1.readLine();
	}
	static void solve() throws IOException{
		int len = number.length();
		
		System.out.println(len);
		String strLine="";
		
		while ((strLine = in2.readLine()) !=null) {
			strLine = strLine.trim();
			if(len != strLine.length()) continue;
			
			else if (number.equals(score(strLine))) set.add(strLine);  
		}
      
      
		StringBuilder sb = new StringBuilder();
		
		if (set.size() ==0) out.println("NONE");
		else {
			for(String name:set)
				sb.append(name).append("\n");
			out.print(sb.toString());
		}
	}
	
	public static String score(String a) {
		String ret = "";
		for(int i =0; i<a.length(); i++)
			ret += getNumber(a.charAt(i));
		return ret;
	}
	public static int getNumber(char c) {
		if(c=='A'||c=='B'||c=='C') return 2;
		else if(c=='D'||c=='E'||c=='F') return 3;
		else if (c=='G'||c=='H'||c=='I') return 4;
		else if (c=='J'|| c=='K'|| c=='L') return 5;
		else if (c=='M'|| c=='N'|| c=='O') return 6;
		else if (c=='P'||c=='S'||c=='R') return 7;
		else if (c=='V'||c=='T'|| c=='U') return 8;
		else if (c=='W'||c=='X'||c=='Y') return 9;
		
		else return 0;
	}
}