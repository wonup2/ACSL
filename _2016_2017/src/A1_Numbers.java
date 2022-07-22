import java.util.*;
public class A1_Numbers {

	static Scanner in;
	static String s;
	static int k;
	static HashSet<String> set;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		
		init();
		solve();
		
	}
	
	static void init() {
		s = in.next();
		k = in.nextInt();
		
		set = new HashSet<String>();
	}

	
	static void solve() {
		
		permut(s, "");		
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(set);
		Collections.sort(list);
		
		
		//1. The smallest possible number.		
		System.out.println(Long.parseLong(list.get(0)));
			
		
		//2. The largest possible number.
		System.out.println(Long.parseLong(list.get(list.size()-1)));

		
		//3. 50th largest 
		System.out.println(Long.parseLong(list.get(list.size()-50)));
		
			
		//4. The kth smallest possible number
		System.out.println(Long.parseLong(list.get(k-1)));
		
		
		//5.The number closest to the mean of the first two answers above
		
	
		
	}
	static void permut(String left, String right) {
		
		if(left=="") {
			set.add(right);
		}
		
		for(int i=0; i<left.length(); i++) {
			char c = left.charAt(i);
			String l = left.substring(0, i) + left.substring(i+1);
			String r = right + c;
			
			permut(l, r);
		}		
	}		
}

//20162017 127
//310320380 841