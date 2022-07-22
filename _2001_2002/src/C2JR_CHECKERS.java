import java.util.*;

public class C2JR_CHECKERS {

	static Scanner in;
	static int cr, cc, n, ans;
	static LinkedList<Integer> op;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		
		init();
		solve();
	}
	
	static void init() {
		
		cr = in.nextInt();
		cc = in.nextInt();
		n = in.nextInt();
		op = new LinkedList<Integer>();
		
		for(int i=0; i<n; i++) {
			op.add(in.nextInt());
			op.add(in.nextInt());
		}
		
		System.out.println(op);
	}

	static void solve() {
		
		move(cr, cc, 0);
		System.out.print(ans);			

		
	}
	
	static void move(int cr, int cc,  int ans) {
		if(cr==8) {
			System.out.println(" King"); return;
		}
		if(op.size()==0 ) {
		
			System.out.println(ans); 
		}
		
		
		System.out.print(cr+" "+cc+ ": ");
		int opr = op.remove(0);
		int opc = op.remove(0);
		System.out.println(opr+" "+opc);

		int nr = cr+1;
		int lc = cc-1;
		int rc = cc+1;
		
		if(opr==nr) {
			if(opc==lc) {
				//|| cr<=0 || cc<=0 || cr>9 || cc>9
				move(cr+2, cc-2, ans+1);

			}
			else if(opc==rc) {
				move(cr+2, cc+2, ans+1);
			}			
		}
	}
}


/*
2 2 3 3 3 5 5 7 7
1 5 4 2 4 2 6 3 7 3 3
*/