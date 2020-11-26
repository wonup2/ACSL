import java.util.*;
import java.io.*;

public class C1_Junior {

	public static void main(String[] args) throws IOException{
		
		Scanner in = new Scanner(new File("1920c1jr.in"));
		
		for(int q = 0; q < 5; q++) {
			
			String n = in.next();
			int p = in.nextInt()-1;
			int d = in.nextInt();
			
			n = new StringBuilder(n).reverse().toString();
			
			String[] nums = n.split("");
				
			int digit = Integer.parseInt(nums[p]);
			
			if(digit<=4) {
				digit+=d;
				digit=digit%10;
				nums[p]=digit+"";
				for(int i = 0; i < p; i++) {
					nums[i]=0+"";
				}
			}
			else if(digit>4) {
				digit-=d;
				digit=Math.abs(digit);
				digit=Integer.parseInt((digit+"").substring(0, 1));
				//System.out.println(digit);
				nums[p]=digit+"";
				for(int i = 0; i < p; i++) {
					nums[i]=0+"";
				}
			}
			
			String ans = "";
			for(int i = nums.length-1; i >= 0; i--) {
				ans+=nums[i];
			}
			
			System.out.println(ans);
			
		}
		
	}

}
