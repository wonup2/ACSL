import java.util.*;
import java.io.*;

public class C2JR_Asterisks {

	static Scanner in;
	static String s;
	static int n1, n2;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("c2jr.in"));
		
		for(int i=0; i<9; i++) {
			try {
				init();
				solve();				
			}catch(Exception e) {
				System.out.println("error");
			}
		}
		in.close();
	}

	private static void init() {
		s = in.next();
		n1 = in.nextInt();
		if(s.equals("B")) n2 = in.nextInt();
		
		//System.out.println(s+" "+n1+" "+n2);
	}
	
	private static void solve() {
		
	}
}
