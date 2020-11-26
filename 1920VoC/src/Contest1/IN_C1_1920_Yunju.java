package Contest1;
/*
Yunju Song
10th grade
Voice of Calling
Contest 1 Intermediate 3
*/

import java.io.*;
import java.util.*;

public class IN_C1_1920_Yunju {
	static Scanner in;
	static int N;
	static int P;
	static String[] t;
	static long[] n;
	static int a;
	public static void main(String[] args) throws IOException{
		
		in = new Scanner(new File("C1_1920.in"));
		
		 for(int i=0; i<5; i++){
				try{			
					init();
					System.out.println(solve());			
				}
				catch(Exception e){
					System.out.println("Error");
				}
	        }
		 
		 in.close();
	}
	static void init(){
		long N = in.nextLong();
		int P = in.nextInt();
		String temp = ""+N;
		n = new long[temp.length()];
		t = temp.split("");
		for(int i = 0; i < temp.length(); i++){
			n[i] = Integer.parseInt(t[i]);
		}
		a = n.length-P;
		
	}
	static String solve(){
		String result = "";
		for(int i = 0; i < a; i++){
			n[i]= (n[i] + n[a]);
		}
		for(int j = a +1;j<n.length;j++){
			n[j] = (Math.abs(n[j] - n[a]));
		}
		for(int k = 0; k < n.length; k++){
			if(n[k] > 9){
				n[k] = n[k] %10;
			}
			result += n[k] + "";
		}		
		return result;
	}
}
