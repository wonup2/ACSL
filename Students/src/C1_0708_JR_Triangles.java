import java.util.*;

public class C1_0708_JR_Triangles {

	static Scanner in;
	static double a[], b[];
	static int cnt;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
		
	}

	static void init() {
		
		a = new double[3];
		b = new double[3];
		
		for(int i=0; i<3; i++) a[i] = in.nextDouble();
		for(int i=0; i<3; i++) b[i] = in.nextDouble();
		
		//System.out.println(Arrays.toString(a));
		//System.out.println(Arrays.toString(b));

	}
	
	static void solve() {
		
		for(int i=0; i<3; i++) {
			
			for(int j=0; j<3; j++) {
				
				if(a[i]==b[i]) {
					cnt++;
					b[i] = 0;
				}				
			}			
		}
		
		System.out.println(cnt);
	}
}
