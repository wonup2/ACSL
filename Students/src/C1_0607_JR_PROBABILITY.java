import java.util.*;

public class C1_0607_JR_PROBABILITY {

	static Scanner in;
	static int option, red, blue, left, right;
	static char replace, c1, c2;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void init() {
		option = in.nextInt();
		red = in.nextInt();
		blue = in.nextInt();
		
		if(option==1) {			
			c1 = in.next().charAt(0);
		}
		else {
			replace = in.next().charAt(0);
			c1 = in.next().charAt(0);
			c2 = in.next().charAt(0);
		}
		
		//System.out.println(option+" "+red+" "+ blue+" "+replace+" "+c1+" "+c2);
	}

	static void solve() {
		
		int total = red + blue;
		
		if(option==1) {
			left = c1=='R'? red:blue;
			right = total;
		}
		else {
			if(c1!=c2) left = red*blue;
			
			if(replace=='N') {
				if(c1=='R'&&c2=='R') left = red * (red-1);
				else left = blue * (blue-1);
				
				right = (total) * (total-1);
			}
			else {
				if(c1=='R'&&c2=='R') left = red * red;
				else left = blue * blue;
				
				right = total * total;
			}
		}
		
		System.out.println(left+"/"+right);
	}
}
