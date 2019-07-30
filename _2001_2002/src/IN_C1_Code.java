import java.io.*;
import java.util.*;

public class IN_C1_Code {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("IN_0102c1.in"));
	
		for(int i=0; i<5; i++){
			String input = in.nextLine().replace(" ", "");
			String[] temp = input.split(",");
			int result = 1;
			
			for(int j=0; j<temp.length-1; j++){
				int c = temp[j].charAt(0)-64;
							
				if(c >= 1 && c <= 5)
					result += c * 2;
				else if(c>=6 && c<=10)
					result += c % 3 * 5;
				else if(c>=11 && c<=15)
					result += c / 4 * 8;
				else if(c>=16 && c<=20)
					result += (c/10 + c%10) * 10;
				else if(c>=21 && c<=26)
					result += maxFactor(c) * 12;
			
				if(result > 26)	result %=26;
							
				System.out.print((char)(result+64)+" ");	
			}
			
			System.out.println();
		}
		in.close();
	}
	
	public static int maxFactor(int n){
		for(int i = n/2; i > 0; i--)
			if(n % i == 0) return i;
			
		return 1;
	}
}
