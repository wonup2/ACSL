import java.util.*;
import java.io.*;

public class C1JR_Triangle {

	static Scanner in;
	static double t1[], t2[];
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("c1jr_triangle.in"));
		
		for(int i=0; i<5; i++) {
			try {
				init();   //get data
				solve();  //processing and output
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		in.close();
	}
	
	static void init() {
		t1=new double[3];
		t2=new double[3];
		
		for(int j=0; j<3; j++) t1[j]=in.nextDouble();
		for(int j=0; j<3; j++) t2[j]=in.nextDouble();
	}
	
	static void solve() {	

		int cnt = 0;
		
		for(int j=0; j<3; j++) {
			for(int k=0; k<3; k++) {
				if(t1[j]==t2[k]) {
					cnt++;
					t2[k]=0;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
