//Stempia Computer
//Junior5 Division
//Eunchae Kim, 9th grade

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
    			if (nums[n].charAt(0) == nums[n].charAt(1)) {
    				ans += 1;
    			} else {
    				for (int i = n + 1; i < nums.length; i++) {
    					if (nums[n].charAt(0) == nums[i].charAt(1) && nums[n].charAt(1) == nums[i].charAt(0)) {
    						ans++;
    					}
    				}
    			}
    		}
    	}
    	
    	int max = 0;
    	
    	ArrayList<String> num1 = new ArrayList<String>();
    	ArrayList<String> num2 = new ArrayList<String>();
    	ArrayList<String> num3 = new ArrayList<String>();
    	ArrayList<String> num4 = new ArrayList<String>();
    	ArrayList<String> num5 = new ArrayList<String>();
    	ArrayList<String> num6 = new ArrayList<String>();
    	ArrayList<String> num7 = new ArrayList<String>();
    	ArrayList<String> num8 = new ArrayList<String>();
    	ArrayList<String> num9 = new ArrayList<String>();
    	
    		for (int j = 0; j < nums.length; j++) {
    			if (nums[j].charAt(0) == '1') {
    				num1.add(nums[j]);
    			} else if (nums[j].charAt(0) == '2') {
    				num2.add(nums[j]);
    			} else if (nums[j].charAt(0) == '3') {
    				num3.add(nums[j]);
    			} else if (nums[j].charAt(0) == '4') {
    				num4.add(nums[j]);
    			} else if (nums[j].charAt(0) == '5') {
    				num5.add(nums[j]);
    			} else if (nums[j].charAt(0) == '6') {
    				num6.add(nums[j]);
    			} else if (nums[j].charAt(0) == '7') {
    				num7.add(nums[j]);
    			} else if (nums[j].charAt(0) == '8') {
    				num8.add(nums[j]);
    			} else if (nums[j].charAt(0) == '9') {
    				num9.add(nums[j]);
    			}
    		}
    		
        	if (choice == 2) {
    		
    		if (num1.size() > max) {
    			max = num1.size();
    			ans = 0;
    			for (int n = 0; n < num1.size(); n++) {
    				ans += Integer.parseInt(num1.get(n));
    			}
    		}
    		if (num2.size() > max) {
    			max = num2.size();
    			ans = 0;
    			for (int n = 0; n < num2.size(); n++) {
    				ans += Integer.parseInt(num2.get(n));
    			}
    		}
    		if (num3.size() > max) {
    			max = num3.size();
    			ans = 0;
    			for (int n = 0; n < num3.size(); n++) {
    				ans += Integer.parseInt(num3.get(n));
    			}
    		}
    		if (num4.size() > max) {
    			max = num4.size();
    			ans = 0;
    			for (int n = 0; n < num4.size(); n++) {
    				ans += Integer.parseInt(num4.get(n));
    			}
    		}
    		if (num5.size() > max) {
    			max = num5.size();
    			ans = 0;
    			for (int n = 0; n < num5.size(); n++) {
    				ans += Integer.parseInt(num5.get(n));
    			}
    		}
    		if (num6.size() > max) {
    			max = num6.size();
    			ans = 0;
    			for (int n = 0; n < num6.size(); n++) {
    				ans += Integer.parseInt(num6.get(n));
    			}
    		}
    		if (num7.size() > max) {
    			max = num7.size();
    			ans = 0;
    			for (int n = 0; n < num7.size(); n++) {
    				ans += Integer.parseInt(num7.get(n));
    			}
    		}
    		if (num8.size() > max) {
    			max = num8.size();
    			ans = 0;
    			for (int n = 0; n < num8.size(); n++) {
    				ans += Integer.parseInt(num8.get(n));
    			}
    		}
    		if (num9.size() > max) {
    			max = num9.size();
    			ans = 0;
    			for (int n = 0; n < num9.size(); n++) {
    				ans += Integer.parseInt(num9.get(n));
    			}
    		}
    	} 

    	if (choice == 3){
    		for (int n = 0; n < nums.length; n++) {
    			if (nums[n].charAt(1) == '1') {
    				ans += num1.size();
   				} else if (nums[n].charAt(1) == '2') {
    				ans += num2.size();
    			} else if (nums[n].charAt(1) == '3') {
    				ans += num3.size();
    			} else if (nums[n].charAt(1) == '4') {
    				ans += num4.size();
   				} else if (nums[n].charAt(1) == '5') {
   					ans += num5.size();
   				} else if (nums[n].charAt(1) == '6') {
   					ans += num6.size();
    			} else if (nums[n].charAt(1) == '7') {
    				ans += num7.size();
    			} else if (nums[n].charAt(1) == '8') {
    				ans += num8.size();
    			} else if (nums[n].charAt(1) == '9') {
    				ans += num9.size();
    			}
    		}
    	}
    	return ans;
    }
}