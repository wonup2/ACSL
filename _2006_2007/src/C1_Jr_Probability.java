import java.util.*;
import java.io.*;
public class C1_Jr_Probability {

	static Scanner in;
	static int option, red, blue, top, bottom;
	static char pick1, pick2, replace;
	
	public static void main(String[] args) throws FileNotFoundException {

		in = new Scanner(new File("0607_c1_jr.in"));
		for(int i=0; i<5; i++) {
			init();
			solve();
		}
		in.close();
	}
	
	static void init() {
		option = in.nextInt();
		red = in.nextInt();
		blue = in.nextInt();
		if(option==1) 
			pick1 = in.next().charAt(0);
		else {
			replace = in.next().charAt(0);
			pick1 = in.next().charAt(0);
			pick2 = in.next().charAt(0);
		}
	}	
	
	static void solve() {
	
		bottom = red+blue;
		top = pick1 =='R' ? red:blue;
		
		if(option==2) {			
			if(replace=='Y') {
				bottom *= bottom;
				top *= pick2=='R' ? red:blue;
			}			
			else {
				bottom *= bottom-1;
				top *= pick1==pick2 ? top-1:pick2=='R' ? red:blue;
			}
		}
		
		System.out.println(top +"/" + bottom);
	}		
}

