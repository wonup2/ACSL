package Contest2;
/*
Clay Shin
Grade 10
STEMPIA
Intermediate 5
Contest 2
*/


import java.io.*;
import java.util.*;
public class c2_Clay {
	static Scanner in;
	static String a, b;
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("1920c2in.in"));
		for(int g = 0; g < 5; g++) {
			a = in.next();
		    b = in.next();
            removesame();
	        while(true) {
	            if(shiftone()==false) break;
	            removesame();
	        }
	        int ans = 0;
	        for(int i = 0; i < a.length() && i < b.length(); i++) {
	        	ans += (a.charAt(i) - b.charAt(i));
	        }
	        ans += Math.abs(a.length() - b.length());        
	        System.out.println(ans);
        }
	}

	static void removesame() {
        for(int i = 0 ; i < a.length() && i < b.length(); i++) {
            if(a.charAt(i) == b.charAt(i)) {
                a = a.substring(0, i) + a.substring(i + 1);
                b = b.substring(0, i) + b.substring(i + 1);
                i--;
            }
        }
    }
	
	static boolean shiftone() {
        for(int i = 0; i < a.length()-1 && i < b.length()-1; i++) {
        if(a.charAt(i) == b.charAt(i + 1)) {
            b = b.substring(0, i) + b.substring(i + 1);
            return true;
            }
        else if(b.charAt(i) == a.charAt(i+1)) {
            a = a.substring(0, i) + a.substring(i + 1);
            return true;
            }
        }
        return false;
    }
}