import java.util.*;

public class ACSL_mail {

	static Scanner in;
	static int n, k;
	static char gate;
	static TreeSet<pair> os, es;
	static LinkedList<pair> oh, eh;
	static pair start, ans;
	
	static class pair implements Comparable<pair>{
		char gate;
		int num;
		
		pair(char c, int n){
			gate = c;
			num = n;
		}
		@Override
		public int compareTo(ACSL_mail.pair that) {
			if(this.gate==that.gate) return this.num-that.num;
			return this.gate-that.gate;
		}
		
		public String toString() {
			return ""+gate+num;
		}
		
		
	}
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		init();
		solve();
	}

	static void init() {
		os = new TreeSet<pair>();
		es = new TreeSet<pair>();
		
		oh = new LinkedList<pair>();
		eh = new LinkedList<pair>();

		buildHouse(); // System.out.println(os);System.out.println(es);
		
		n = 4;		
		while(n-->0) solve();
	}
	
	static void solve() {
		
		buildHouse();  			//os, es
		reset();  				//oh, eh, start, gate, k	
		visit(oh, 1); 			//ans
		if(k>1) visit(eh, 2); 	//ans
		
		System.out.println(ans);
	}
	
	static void buildHouse() {
		int t = in.nextInt();  
		
		for(int i=0; i<t; i++) {
			String s = in.next();
			char c = s.charAt(0);  
			int n = Integer.parseInt(s.substring(1));
			if(n%2==1) os.add(new pair(c, n));
			else es.add(new pair(c, n));			
		}		
	}
	
	static void reset() {
		
		gate = in.next().charAt(0);
		k = in.nextInt();
		
		oh.clear(); oh.addAll(os);
		eh.clear(); eh.addAll(es);		
		
//		System.out.println("\ngate " + gate);
//		System.out.println(oh);
//		System.out.println(eh);
	}
	
	static void visit(LinkedList<pair> house, int i) {
		
		while(true) {
			if(gate<=house.get(0).gate) {
				start = house.get(0);
				break;
			}
			house.add(house.remove());
		}
		
		while(true) {			
			if(k==i) {ans = house.get(0); break;}
			house.add(house.remove()); 
			if(start==house.get(0)) break;
			k--; 
		}			
	}
}

/*
5 A435 B84 B97 B124 D4301
1 C321 B 4
2 C2 C84 A 5
0 B 7
1 D34 D 9
3 A241 B510 D43 C 10

6 B40 B20 C60 A312 D2 D15
0 D 5
2 B7 B50 A 3
2 B30 B60 C 7
1 C153 C 1
4 A111 C525 C100 D81 B 12






*/
