import java.util.*;

public class SetPractice {

	public static void main(String[] args) {

		Set<Integer> s1 = new HashSet<Integer>();
		s1.add(10);
		s1.add(50);
		s1.add(60);
		s1.add(10);
		s1.add(60);

		for(int n:s1) {
			System.out.print(n+" ");
		}
		
		System.out.println();		
		
		Set<Integer> s2 = new TreeSet<Integer>();
		s2.add(10);
		s2.add(50);
		s2.add(60);
		s2.add(10);
		s2.add(60);
		for(int n:s2) {
			System.out.print(n+" ");
		}
		
		System.out.println();		

		Set<Integer> s3 = new LinkedHashSet<Integer>();
		s3.add(100);
		s3.add(50);
		s3.add(60);
		s3.add(10);
		s3.add(60);
		for(int n:s3) {
			System.out.print(n+" ");
		}
		System.out.println();
		
		//methods		
		System.out.println(s3.size());
		System.out.println(s3.contains(60));
		System.out.println(s3.remove(60));
		System.out.println(s3);
		System.out.println(s3.hashCode());
		
	}
}
