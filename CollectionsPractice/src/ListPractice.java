import java.util.*;

public class ListPractice {

	public static void main(String[] args) {


		ArrayList<Integer> a = new ArrayList<Integer>();
		
		a.add(30);
		a.add(10);
		a.add(20);
	
		
		System.out.println(a);
		
		a.add(1, 100);
		System.out.println(a);

		System.out.println(a.get(3));
		
		a.set(1, 15);
		System.out.println(a);
		
		Collections.sort(a);
		System.out.println(a);
		Collections.sort(a, Collections.reverseOrder());
		
		System.out.println(a);
		
		
		a.remove(0);
		System.out.println(a);
		
		
		LinkedList<String> b = new LinkedList<String>();
		
		b.add("aaa");
		b.add("ccc");
		b.add("zzz");
		b.remove("zzz");
		System.out.println(b);

	}
}
