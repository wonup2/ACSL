import java.util.*;
import java.io.*;

public class Template_old {

	static Scanner in;
	static String s;
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("temp.in"));
		
		for(int i=0; i<5; i++) {
			try {
				init();
				solve();
			}
			catch(Exception e) {
				System.out.println("Error");
				e.printStackTrace();
			}
		}
		in.close();		
	}
		
	static void init() {
		s = in.nextLine();
	}
		
	static void solve() {
		
	}

}
