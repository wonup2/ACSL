import java.util.*;
import java.io.*;

public class C1JR_Code {

	static Scanner in;
	static char c;
	
	public static void main(String[] args) throws IOException  {
		
		in = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			try {
				init();
				solve();
			}
			catch(Exception e) {
				
				e.printStackTrace();
				System.out.println("error");
			}			
		}
		
		in.close();
	}		
	
	private static void init() {
		c=in.next().charAt(0);
	}
		
	private static void solve() {
		
		int n = c - 64;
		
		if('A'<=c && c<='E') n *= 2;		
		else if ('F'<=c && c<='J') n = n % 3 * 5;	
		else if ('K'<=c && c<='O') n = n / 4 * 8;	
		else if ('P'<=c && c<='T') n = (n / 10 + n % 10) * 10;
		else if ('U'<=c && c<='Z') n = gcf(n) * 12;
		
		n %= 26;
		if(n==0) n=26;
		
		//output		
		n += 64;
		System.out.println((char)n);		
	}
	
	private static int gcf(int n) {
		
		for(int i = n/2; i>=1; i--) {
			if(n % i == 0) return i;
		}		
		return 1;
	}
}

/*
B
A
C
F
G

*/