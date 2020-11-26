import java.util.*;
import java.io.*;

public class C2_Intermediate {

	static Scanner in;
	static String a, b;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920c2in.in"));
		for(int i=0; i<5; i++) {
			init();
			solve();
		}
	}
	
	static void init() {
		a = in.next();
		b = in.next();
	}
	
	static void solve() {
	
		while(true) {
			remove();
			if(!shift()) break;
		}
		System.out.println(calculate());		
	}
	
	static void remove() {

		for(int i=0; i<a.length() && i<b.length(); i++) {
			if(a.charAt(i)==b.charAt(i)) {
				a=a.substring(0,i)+a.substring(i+1);
				b=b.substring(0,i)+b.substring(i+1);
				i--;
			}
		}		
	}
	
	static boolean shift() {
		a=a+"0";
		b=b+"1";
		for(int i=0; i<a.length()-1 && i<b.length()-1; i++) {
			
			if(b.charAt(i+1)==a.charAt(i)) {
				b=b.substring(0,i)+b.substring(i+1);
				reset();
				return true;
			}
			
			if(a.charAt(i+1)==b.charAt(i)) {
				a=a.substring(0,i)+a.substring(i+1);
				reset();
				return true;
			}
		}	
		reset();
		return false;
	}		
	
	static int calculate() {
		int n=0;
		int min = Math.min(a.length(), b.length());
		for(int i=0; i<min; i++) 
			n += (a.charAt(i)-b.charAt(i));
		
		n+= a.length()-min + b.length()-min;  
		return n;
	}
	
	static void reset() {
		a=a.replace("0","");
		b=b.replace("1","");
	}
}
