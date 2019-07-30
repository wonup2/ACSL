import java.io.*;
import java.util.*;

public class JR_C1_Code {

	public static void main(String[] args) throws IOException {
		//input data from file 
		Scanner in = new Scanner(new File("0102c1.in"));
	
		for(int i=0; i<5; i++){
			int input = in.nextLine().charAt(0)-64;		
			int result = 0;
			
			if(input>=1 && input<=5)
				result = input * 2;
			else if(input>=6 && input<=10)
				result = input % 3 * 5;
			else if(input>=11 && input<=15)
				result = input / 4 * 8;
			else if(input>=16 && input<=20)
				result = (input/10 + input%10) * 10;
			else if(input>=21 && input<=26)
				result = maxFactor(input) * 12;
			
			if(result > 26)	result %=26;
			if(result == 0)	result = 26;
			
			result += 64;
			System.out.println((char)result);				
		}
		in.close();
	}
	
	public static int maxFactor(int n){
		for(int i = n/2; i > 0; i--)
			if(n % i == 0) return i;
			
		return 1;
	}
}
