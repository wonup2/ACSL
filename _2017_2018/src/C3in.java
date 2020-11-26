import java.util.*;
import java.io.*;

public class C3in {
	static char[][] a;
	static Scanner in;
	static int r, c, m;
	static char d;
	public static void main(String[] args) throws IOException {
		init();
		in = new Scanner(new File("1718c3in.in"));
		for(int i=0; i<5; i++) {
			init1();
			solve();
		}
	}

	static void init() {
		a = new char[8][];				
		
		for(int i=0; i<8; i++) {
			int num = Integer.parseInt(in.next(), 16);	
			String bin = Integer.toBinaryString(num);
			bin = String.format("%8s", bin).replace(" ","0");	
			a[i] = bin.toCharArray();
		}
	}
	
	static void init1() {
		r = in.nextInt();
		c = in.nextInt();
		d = in.next().charAt(0);
		m = in.nextInt();
	}
	
	static void solve() {
		
	}
	
	static void fromL() {
		
	}
	
	static void fromR() {
		
	}
	
	static void fromB() {
		
	}
	
	static void fromA() {
		if(a[r][c]==0) r=r+1;
		else {
			if(a[r][c]==1) {
				a[r][c]=2;
				c=c+1;
			}
			else if(a[r][c]==2){
				a[r][c]=2;
				c=c+1;
			}
			else if(a[r][c]==3){
				a[r][c]=2;
				c=c+1;
			}
			else if(a[r][c]==4){
				a[r][c]=2;
				c=c+1;
			}
		}
	}
}
