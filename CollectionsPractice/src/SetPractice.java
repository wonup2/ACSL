import java.util.*;
public class SetPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet<Integer> set = new HashSet<Integer>();
		
		
		set.add(10);
		set.add(300);
		set.add(250);
		set.add(10);
		
		System.out.println(set);
		
		for(int n:set)
			System.out.println(n);
	}

}
