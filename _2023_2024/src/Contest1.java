import java.util.Scanner;
import java.util.*;

public class Contest1
{
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int originalRows = in.nextInt(); in.nextLine();
		String tiles = in.nextLine();
		
		int result = findDiscardSum(originalRows, tiles);
		System.out.println(result);
		
	}
	
	public static int findDiscardSum(int originalRows, String tiles) {
		 ArrayList<Integer> rows = new ArrayList<Integer>();
		 ArrayList<Integer> discard = new ArrayList<Integer>();

		 int a, b;

		 String str = String.valueOf(originalRows);
		 for(char c : str.toCharArray()){
			 rows.add(c - '0');
		 }
		 
		// System.out.println(rows);

		 String[] nums = tiles.split(" ");
		 boolean twice = false;
		// System.out.println(Arrays.toString(nums));
		 
		 
		 whole:
		 for(String s : nums){
			 a = Integer.parseInt(s) / 10;
			 b = Integer.parseInt(s) % 10;
	
			 System.out.println(s+" "+ a+ " "+ b);
			 
			 for(int i = 0; i < 4; i++){
				 if(a == rows.get(0) || b == rows.get(0)){
	
					 if(a == rows.get(0)){
						 rows.set(0, b);
					 }else{
						 rows.set(0, a);
					 }					 
					 
					 if(a != b){
						 twice = false;
						 rows.add(rows.remove(0));
					 }else{
						 twice = true;
					 }
					 
					 System.out.println("1: "+ a+" "+b + " "+twice+" "+rows);
					 continue whole;
				 }
			 
				 if(!twice){
					 rows.add(rows.remove(0));
				 }else{
					 break;
				 }
				 System.out.println("2: "+ a+" "+b + " "+twice+" "+rows);

			 }
			
			 discard.add(a);
			 discard.add(b);
			 
			 System.out.println("rows: "+rows);
			 System.out.println("discard: "+discard);
		 }

		 int total = 0;
		 for(int i : discard){
			 total += i;
		 }
		 return total;
	}
}
//1333537957397743722212
