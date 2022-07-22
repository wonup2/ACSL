import java.util.*;
public class A1_numbers {

	static Scanner in;
	static ArrayList<String> list;
	static HashSet<String> set;
	static String s;
	static int k;
	public static void main(String[] args) {

		in = new Scanner (System.in);
		init();
		//solve();
	}

	static void init() {
		
		s = in.next();
		k = in.nextInt();
		list = new ArrayList<String>();
		set = new HashSet<String>();
		permut(s, "");		
	}
	
	static void permut(String left, String right) {
		
		if(left.equals("")) {
			set.add(right);
			return;
		}
		
		for(int i=0; i<left.length(); i++) {
			
			char c = left.charAt(i);
			String r = right+c;
			String l = left.substring(0,i) + left.substring(i+1);
			permut(l, r);
		}
	}
	
	
		
	static void solve() {
		
		list.addAll(set);
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
		


	}
}
