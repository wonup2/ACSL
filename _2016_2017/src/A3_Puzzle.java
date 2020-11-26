import java.util.*;
import java.io.*;

public class A3_Puzzle {
	
	static Scanner in;
	static String ans;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1617A3.in"));
		init0();
		for(int i=0; i<10; i++) {
			try {
				init();
				solve();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	static void init0() {
		
	}
	
	static void init() {
		
	}
	static void solve() {
		
	}
}

class puz implements Comparable<puz>{

	int w, h, l;
	
	puz(int w, int h, int l){
		
	}
	
	@Override
	public int compareTo(puz arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
