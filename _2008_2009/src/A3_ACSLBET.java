import java.util.*;
import java.io.*;

public class A3_ACSLBET {
	static String a;
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner (System.in);

		init();
		solve();
	}

	
	static void init(){
		a = "";
		String temp = in.nextLine();
		for(int i=0; i<temp.length(); i++) {
			char c = temp.charAt(i);
			if(c=='*') a+=Integer.toBinaryString(27);
			else if(c=='/') a+=Integer.toBinaryString(28);
			else if(c=='$') a+=Integer.toBinaryString(29);
			else if(c=='%') a+=Integer.toBinaryString(30);
			else if(c=='#') a+=Integer.toBinaryString(31);
			else a+=Integer.toBinaryString(c-64);
		}
		System.out.println(a);
		
	}
	
	
	static void solve() {
		String result = "";
		//1 LCIRC-2
		String temp = cir(a, false, 2); //System.out.println(temp);
		result += conv(temp) +"\n";		
		
		//2. RSHIFT–4
		temp = shift(a, true, 4);
		result += conv(temp) +"\n";
		
		//3. RCIRC–10
		temp = cir(a, true, 10); //System.out.println(temp);
		result += conv(temp) +"\n";
		
		//4. LSHIFT–8
		temp = shift(a, false, 8);
		result += conv(temp) +"\n";

		//5. LCIRC–5(RSHIFT–3)
		temp = cir(shift(a, true, 3), false, 5);
		result += conv(temp) +"\n";
		
		//6. LSHIFT –5(RCIRC-8)
		temp = shift(cir(a, true, 8), false, 5);
		result += conv(temp) +"\n";	
		
		//7. RSHIFT-2 AND LCIRC-4
		temp = and(shift(a, true, 2), cir(a, false, 4));
		result += conv(temp) +"\n";	
		
		//8. RCIRC-6 OR LCIRC-3
		temp = or(cir(a,true, 6), cir(a,false, 3));
		result += conv(temp) +"\n";	
		
		//9. LSHIFT–9 XOR LCIRC–7
		temp = xor(shift(a, false, 9), cir(a,false, 7));
		result += conv(temp) +"\n";	
		
		//10. RCIRC-4 OR LCIRC-2 AND RSHIFT-1
		temp = or(cir(a,true,4),and(cir(a,false, 2), shift(a,true, 1)));	
		result += conv(temp) +"\n";	
	
		System.out.println(result);
	}
	
	static String conv(String s) {
		String ret="";
		while(s.length()>=5) {
			String temp = s.substring(s.length()-5); //System.out.println(temp);
			int n = Integer.parseInt(temp, 2);
			ret = ntoc(n)+ret; 
			s = s.substring(0,s.length()-5);
		}
		if(s.length()>0)
			ret = ntoc(Integer.parseInt(s, 2)) + ret;
		return ret;
	}
	
	static String ntoc(int n) {		
		if(n==27) return "*";
		else if(n==28) return "/";
		else if(n==29) return "$";
		else if(n==30) return "%";
		else if(n==31) return "#";
		else if(1<=n && n <=26) return (char)(n+64)+"";
		else return "";
	}
	
	static String cir(String s, boolean b, int n) {
		for(int i=0; i<n; i++) {
			if(b) {
				char c = s.charAt(s.length()-1);
				s = s.substring(0,s.length()-1);
				s = c + s;
			}
			else {
				char c = s.charAt(0);
				s = s.substring(1);
				s = s + c;
			}
		}
		return s;
	}
	
	static String shift(String s, boolean b, int n) {
		String z = "";
		for(int i=0; i<n; i++) {
			z+="0";
		}
		if(b) s = z + s.substring(0,s.length()-n);
		else s = s.substring(n) + z;
		return s;			
	}	
	
	static String and(String a, String b) {
		String ret = "";
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i)=='1' && b.charAt(i)=='1') ret+="1";
			else ret+="0";
		}
		return ret;
	}
	
	static String or(String a, String b) {
		String ret = "";
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i)=='1' || b.charAt(i)=='1') ret+="1";
			else ret+="0";
		}
		return ret;
	}

	static String xor(String a, String b) {
		String ret = "";
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i)== b.charAt(i)) ret+="0";
			else ret+="1";
		}
		return ret;
	}	
}


/*
TEST INPUT: NASA
TEST OUTPUT
1. AL#
2. CV
3. AVO
4. AX
5. ALC
6. A#
7. BX
8. A # #
9. AOV
10. #W
*/