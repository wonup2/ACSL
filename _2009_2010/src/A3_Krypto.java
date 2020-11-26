import java.io.*;
import java.util.*;

public class A3_Krypto {
	static Scanner in;
	static ArrayList<String> op;
	static String[] a;
	public static void main(String[] args) throws IOException { 
		in = new Scanner(new File("A3.in"));
		init0();
	
		
		for(int i=0; i<10; i++) {
			init();
			solve();
		}
	} 
	static void init() {
		a=new String[6];
		a = in.nextLine().replace(" ", "").split(",");
		//System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		int ans = Integer.parseInt(a[5]);
		for(String s:op) {
			if(cal(s)==ans)
				print(s);
		}
	}
	
	static int cal(String s) {
		int ret = Integer.parseInt(a[0]);
		int i = 0;
		for(int index=1; index<a.length-1;index++) {
			int n = Integer.parseInt(a[index]);
			if(s.charAt(i)=='+') ret+=n;
			else if(s.charAt(i)=='-') ret-=n;
			else if(s.charAt(i)=='*') ret*=n;
			else if(s.charAt(i)=='/') ret/=n;
			i++;
		}
		return ret;
	}
	static void print(String s) {
		for(int i=0; i<4; i++)
			System.out.print(a[i]+s.charAt(i));
		System.out.println(a[4]+"="+a[5]);
	}
	static void init0() {
		op = new ArrayList<String>();
		permutation("", "+-*/"); 
		//System.out.println(op);
	}
 
	private static void permutation(String prefix, String str) { 
		int n = str.length(); 
		if (n == 0) op.add(prefix); 
		else { 
			for (int i = 0; i < n; i++) {
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n)); 
			} 
		}
	} 
}
