package Contest1;
/*
Name: Davin Jeong
Grade: 9
Team: Stempia 
Division: Junior 5
Contest 1
*/

import java.io.*;
import java.util.*;

public class JR_numTransfer_Davin {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("1920c1jr.in"));
		
		for(int z = 0; z<5; z++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			char[] line = st.nextToken().toCharArray();
			int p = line.length - Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int digit = line[p]-'0';
			//System.out.println(p + " " + d + " " + digit);
			
			if(digit>=0 && digit<=4) {
				digit=(digit+d)%10;
				line[p] = (char)(digit + 48);
			}
			else if(digit>=5 && digit<=9) {
				digit = Math.abs(digit-d);
				while(digit>=10) digit/=10;
				line[p] = (char)(digit+48);
				//System.out.println((char)(digit+48));
			}
			else {
				System.out.println("ERROR");
				break;
			}
			
			String res = "";
			for(int i = 0; i<=p; i++) res += line[i];
			for(int i = p+1; i<line.length; i++) res += '0';
			
			System.out.println(res);
		}
	}
	
}

