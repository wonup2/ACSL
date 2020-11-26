import java.util.*;
public class SetPra {

	public static void main(String[] args) {

		HashSet<Integer> s = new HashSet<Integer>();
		
		s.add(1);
		s.add(2);
		s.add(3);
		
		System.out.println(s);
		
		s.add(2);
		
		System.out.println(s);

	}

}
