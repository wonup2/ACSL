import java.util.*;

public class permutation {
	static ArrayList<String> list;
	static HashSet<String> set;
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String s = in.next();
		int k = in.nextInt();
		
		set = new HashSet<String>();
		list = new ArrayList<String>();
		permut(s, "");

		list.addAll(set);		
		Collections.sort(list);
		
		
		//1
		long small = Long.parseLong(list.get(0));
		System.out.println(small);
		
		//2
		long large = Long.parseLong(list.get(list.size()-1));
		System.out.println(large);

		//3
		System.out.println(Long.parseLong(list.get(list.size()-50)));

		//4
		System.out.println(Long.parseLong(list.get(k-1)));

		//5
		long mean = (small+large)/2;
		long diff=0;
		long minDiff = Long.MAX_VALUE;
		int idx = 0;
		
		for(int i=0; i<list.size(); i++) {
			long temp = Long.parseLong(list.get(i));
			diff = Math.abs(temp-mean);
			
			if(diff<minDiff) {
				minDiff = diff;
				idx = i;
			}
		}
		
		System.out.println(Long.parseLong(list.get(idx)));
	}

	static void permut(String left, String right) {
		
		if(left.equals("")) set.add(right);
		
		for(int i=0; i<left.length(); i++) {
			
			char c = left.charAt(i);
			String l = left.substring(0,i) + left.substring(i+1);
			String r = right + c;
			
			permut(l, r);
		}		
	}
}
