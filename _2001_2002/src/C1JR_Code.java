import java.util.*;
import java.io.*;


public class C1_jr_Code {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("0102c1.in"));
		for(int i=0; i<5; i++){
			
			//get data 
			int n = in.nextLine().charAt(0) - 'A' + 1;  //skill
					
			int result=0;
			//processing
			//step 1
			if(1<=n && n<=5)
				result = n*2;
			else if(6<=n && n<=10)
				result = n%3*5;
			else if(11<=n && n <=15)
				result = n/4*8;
			else if(16<=n && n <=20)
				result = (n/10 + n%10)*10;
			else if(21<=n && n <=26){
				System.out.println(n+" "+gcf(n));
				result = gcf(n) * 12;
			}
			//step 2
			if(result>26)
				result %= 26;
			if(result ==0)
				result = 26;
			
			//print output
			System.out.println((char)(result-1+'A'));
		}
			
	}

	static int gcf(int n){
		for(int i=n/2; i>1; i--)
		{
			if(n%i==0) return i;
		}
		
		return 1;
	}
}
