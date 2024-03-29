import java.util.*;
import java.io.*;

public class C1_IN_NumberTransformation{

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner (new File("1920C1IN.in"));
		
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