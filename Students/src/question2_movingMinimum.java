import java.util.*;
import java.io.*;

public class question2_movingMinimum {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt(); 
		int[] list = new int[n];
		ArrayList<Integer> ans = new ArrayList<Integer>();
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		for (int i = 0; i < n; i++) {
			list[i] = in.nextInt();
		}
		
		int m = in.nextInt();
		
		for (int  i = 0; i < m; i++) {
			map.put(list[i], 1);
		}
		System.out.println(map);
		for (int i = m; i < list.length; i++) {
			
			if (map.containsKey(list[i]))
				 map.replace(list[i], map.get(list[i]) + 1);
            else map.put(list[i], 1);
			//System.out.println(map);
			map.put(list[i - m], map.get(list[i - m]) - 1);
			
			if (map.get(list[i - m]) == 0)
				map.remove(list[i - m]);
			//System.out.println(map);	
			ans.add(map.firstKey());
			
		}
		
		//for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans);
		//}
		
	}
	
	

}
