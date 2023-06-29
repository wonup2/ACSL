import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ACSLC42223 {
	
	static Scanner in;
	
	
	public static String positionToString(int[] pos) {
	    return pos[0] + "" + pos[1];
	  } 

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int size = in.nextInt(); in.nextLine();
		String targets = in.nextLine();
		
		//System.out.println(targets);
		
		HashSet<int[]> targetSet = new HashSet<>();
	    // Split the targets string by space and convert each pair to an int array
		
	    for (String target : targets.split(" ")) {
	      String[] xy = target.split("");
	      int x = Integer.parseInt(xy[0]);
	      int y = Integer.parseInt(xy[1]);
	      targetSet.add(new int[]{x, y});
	    }


	    int maxCount = 0;
	    String maxArrow = "";
	    int[] startPos = null;
	    ArrayList<int[]> list1 = new ArrayList<>();
	    for (int y = 0; y < size; y++) {
	      list1.add(new int[]{0, y});
	    }
	    for (int x = 1; x < size; x++) {
	      list1.add(new int[]{x, 0});
	    }
	    for (int y = 0; y < size; y++) {
	      list1.add(new int[]{size - 1, y});
	    }
	    for (int x = 1; x < size-1; x++) {
	      list1.add(new int[]{x, size - 1});
	    }
	    
	    
	    
	    for (int[] pos : list1) {
	      int x = pos[0];
	      int y = pos[1];
	      
	      // Loop through each possible direction and arrow symbol
	      
	      int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1,-1}};
	      char[] arrows = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
	      //int count = 0;
	      for (int i = 0; i < directions.length; i++) {
	        int dx = directions[i][0];
	        int dy = directions[i][1];
	        char arrow = arrows[i];
	        
	        // Initialize the count and current position variables
	        
	        int[] curPos = new int[]{x + dx, y + dy};
	        
	        
	        int count = 0;
	       
	        // While the current position is within the grid
	        while (curPos[0] >= 0 && curPos[0] < size && curPos[1] >= 0 && curPos[1] < size) {
	        	
	        	if(!targetSet.contains(curPos)) {
	        		curPos[0] += dx;
	        		curPos[1] += dy;
	        	}else {
	        		curPos[0] += dx;
	        		curPos[1] += dy;
	        	
	          // If the current position is not a target, break the loop
		          if (!targetSet.contains(curPos)) {
		            break;
		          } else {
		            // Otherwise, increment the count and update the current position
		            count = count+1;
		            
		            curPos[0] += dx;
		            curPos[1] += dy;
		          }
	        	}
		          
	          
	          System.out.println(count);
	          
	          
	         
	        }
	        
	        
	        // If the count is greater than the maximum count
	        if (count > maxCount) {
	          // Update the maximum count, arrow and start position
	          maxCount = count;
	          maxArrow = positionToString(pos) + arrow;
	          startPos = pos;
	        } else if (count == maxCount) {
	          // If the count is equal to the maximum count
	          if (maxArrow == "") {
	            // If there is no maximum arrow yet, update it with the current one
	            maxCount = count;
	            maxArrow = positionToString(pos) + arrow;
	            startPos = pos;
	          } else if (maxArrow != ""){
	            // If there is already a maximum arrow, compare it with the current one lexicographically
	            String curArrow = positionToString(pos) + arrow;
	            if (curArrow.compareTo(maxArrow) < 0) {
	              // If the current arrow is smaller than the maximum arrow, update it with the current one
	              maxCount = count;
	              maxArrow = curArrow;
	              startPos = pos;
	            }
	          }
	        }
	      }
	      
	      
	    }
	    // Return the maximum arrow
	    System.out.println(maxArrow);
	  
	    }
}