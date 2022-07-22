import java.util.*;

public class Contest4_Junior {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		for(int i=0; i<10; i++) {
			int n = in.nextInt();
			String s = in.nextLine().trim();
			System.out.println(findCharacteristic(n, s));		
		}
	}
	
	public static int findCharacteristic(int choice, String edges) {
		String[] nums = edges.split(" ");
    	int ans = 0;   	

    	if (choice == 1) {
    		for (int n = 0; n < nums.length; n++) {
    			if (nums[n].charAt(0) == nums[n].charAt(1)) ans += 1;
    			
    			else {
    				for(int m=n+1; m<nums.length; m++)
    					if (nums[n].charAt(0) == nums[m].charAt(1) && nums[n].charAt(1) == nums[m].charAt(0)) 
    	    				ans += 1;
    			}
    		}
        	return ans;
    	} 
    	
    	//choice 2
    	ArrayList<String>[] a = new ArrayList[10];
    	int[] sum = new int[10];

    	for(int i=0; i<10; i++) a[i] = new ArrayList<String>();
    	
    	for (int n = 0; n < nums.length; n++) {
    		int ind = nums[n].charAt(0) - '0';
    		a[ind].add(nums[n]);
    		sum[ind] += Integer.parseInt(nums[n]);
    	}
    	int max = 0;
    	for (int n = 0; n < 10; n++) {
    		if(max < a[n].size()) {
    			max = a[n].size();
    			ans = sum[n];
    		}    		
    	}
    	
    	if(choice == 3) {
    		ans = 0;
    		for (int n = 0; n < nums.length; n++) {
    			int ind = nums[n].charAt(1)-'0';
    			ans += a[ind].size(); 
    		}
    	}
    	return ans;
	}
}

/*
2 12 13 23 31 34 41
1 12 23 34 11 21 32 45 53 95 43 99 29 91
3 12 23 34 41 31 52 45 61 14 21 33 55 13 54 32 56 36
1 12 11 33 34 43 55 52 41 31 25 88 79 98 45 13 42 87 35 51 21 14 78
2 12 11 33 34 43 55 52 41 31 25 88 79 98 45 13 42 87 35 51 21 14 78
1 12 31 41 42 43 45 51 63 64 56 16
2 12 13 22 23 24 34 42 98 71 87 17 96 67
3 12 14 21 24 25 32 41 43 59 65 91 87 76 95
2 11 12 14 15 23 2
3 55 77 45 54

*/
