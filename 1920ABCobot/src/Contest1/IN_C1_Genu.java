package Contest1;
//Genu Lee
//ABCobot Intermediate 5
//Contest 1

import java.util.*;
import java.io.*;

public class IN_C1_Genu {

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner (new File("Contest1.in"));
		
		for(int i=0; i<5; i++) {
			String s = in.next();
			int n = s.length()-in.nextInt();
			int a = s.charAt(n)-'0';
			
			String ans = "";
			for(int x=0; x<n; x++) ans+=(s.charAt(x)-'0'+a)%10;
			ans+=a; 
			for(int x=n+1; x<s.length(); x++) ans+= Math.abs(s.charAt(x)-'0'-a)%10;
			System.out.println(ans);
		}
	}

}
