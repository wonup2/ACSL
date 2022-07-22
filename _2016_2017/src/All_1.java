import java.util.*;

public class All_1 {

	static Scanner in;
	static HashSet<String> p;
	static ArrayList<String> list;
	static String s;
	static int k;
	
	public static void main(String[] args) {

		in = new Scanner (System.in);
		
		init();
		solve();
	}
	
	static void init() {
		s = in.next();
		k = in.nextInt();
		p = new HashSet<String>();
		list = new ArrayList<String>();
	}

	static void solve() {
		
		permut(s, "");
		
		list.addAll(p);
		
		Collections.sort(list);
		
		//1
		System.out.println(Long.parseLong(list.get(0)));
		
		//2
		System.out.println(Long.parseLong(list.get(list.size()-1)));

		//3
		System.out.println(Long.parseLong(list.get(list.size()-50)));

		//4
		System.out.println(Long.parseLong(list.get(k-1)));

		//5
		long mean = Long.parseLong(list.get(0)) + Long.parseLong(list.get(list.size()-1));
		mean/=2;
		
		long minDiff = Long.MAX_VALUE;
		int minIdx = 0;
		long diff = 0;
		
		for(int i=0; i<list.size(); i++) {
			
			long num = Long.parseLong(list.get(i));
			diff = Math.abs(num-mean);
			if(diff<minDiff) {
				minIdx = i;
				minDiff = diff;
			}
		}
		
		System.out.println(Long.parseLong(list.get(minIdx)));

	}
	
	static void permut(String left, String right) {
		
		if(left=="") {
			p.add(right);
			return;
		}
		
		for(int i=0; i<left.length(); i++) {
			char c = left.charAt(i);
			String r = right + c;
			String l = left.substring(0, i) + left.substring(i+1);
			permut(l, r);
		}		
		
	}
}
