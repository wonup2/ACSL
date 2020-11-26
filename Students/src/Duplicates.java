import java.util.*;
import java.io.*;
public class Duplicates {
	
	static Scanner in;
	static String[] temporary;
	static ArrayList<Integer> a, b;
	static int c;

	public static void main(String [] args) {
		try {
			in = new Scanner(new File("duplicates.in"));
			for(int i = 0; i < 5; i++) {
				init();
				solve();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void init() {
		a = new ArrayList<Integer>();
		b = new ArrayList<Integer>();
		temporary = in.nextLine().split(" ");
		for(int i = 1; i < temporary.length; i++) {
			temporary[i] = temporary[i].toUpperCase();
		}
		c = Integer.parseInt(temporary[0])-1;
	}
	public static void solve() {
		for(int i = 1; i < temporary.length; i++) {
			String w = temporary[i];
			for(int j = 0; j < w.length(); j++) {
				char ch = w.charAt(j);
				int let = Character.getNumericValue(ch);
				a.add(let);
				Collections.sort(a);
				if(a.size() > c) {
					int tem = a.get(c);
					if(!b.contains(tem))
						b.add(tem);
				}
			}
		}
		System.out.println(b.size());
	}
}