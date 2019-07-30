import java.util.*;
import java.io.*;

public class C1_code {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("0102C1.in"));
		
		for(int i = 0; i < 5; i++){
			
			//get data and organize
			int n = in.next().charAt(0) - 'A' + 1;
			//System.out.println(n);
			
			//processing
			int result = 0;
			if(1 <= n && n <= 5) result = n * 2;
			else if(6 <= n && n <= 10) result = n % 3 * 5;
			else if(11 <= n && n <= 15) result = n / 4 * 8;
			else if(16 <= n && n <= 20) result = (n/10 + n%10)*10;
			else result = gf(n) * 12;
			
			//System.out.println(result);
			
			if(result > 26){
				result = result % 26;
			}
			if(result == 0) result = 26;
			
			System.out.println((char)(result + 'A' - 1));
			
		}	
		
	}

	public static int gf(int n){
		
		for(int i=n/2; i>1; i--){
			if(n % i == 0) return i;
		}
		
		return 1;
	}
	
	
}
