package Contest4;
/*
Catherine Cho 9
2019-2020 ACSL Contest 4 Junior Division
Stempia
*/

import java.util.*;
import java.io.*;
public class JR_patolli_Catherine {
	static int[][] grid= {{0,0,0,0,1, 52,0,0,0,0},
			   {0,0,0,0,2,51,0,0,0,0},
			   {7,6,5,4,3,50,49,48,47,46},
			   {8,9,10,11,12,41,42,43,44,45},
			   {17,16,15,14,13,40,39,38,37,36},
			   {18,19,20,21,22,31,32,33,34,35},
			   {0,0,0,0,23,30,0,0,0,0},
			   {0,0,0,0, 24,29,0,0,0,0},
			   {0,0,0,0, 25,28,0,0,0,0},
			   {0,0,0,0, 26,27,0,0,0,0}};
	static boolean horizontal = false;
	static boolean vertical = false;
	static int curx = 0,cury = 0,endx = 0,endy = 0;
	public static void main(String args[]) throws IOException{
		
		Scanner in = new Scanner(new File("1920c4jr.in"));
		for(int r = 0; r < 5; r++) {
			boolean[] occupied = new boolean[53];
			for(int i =0; i < 3; i++) {
				occupied[in.nextInt()] = true;
			}
			int cur = in.nextInt();
			int n = in.nextInt();
			int[] dieroll = new int[n];
			for(int i =0; i < n; i++) {
				dieroll[i] = in.nextInt();
			}
			
			for(int i = 0; i < n; i++) {
				int endpt = cur+ dieroll[i];
				if(endpt > 52 || occupied[endpt]) {
					continue;
				}
				if(endpt == 52) { // case 6
					cur = endpt;
					break;
				}

				double sq = Math.sqrt(endpt); 
				if(isPrime(endpt)) {
					
					if(cur > 52) 
						continue;
					cur = endpt + 6;
					for(int j = endpt +1; j<= endpt+ 6; j++) {
						if(occupied[j]) {
							cur= j-1;
							break;
						}
					}
				}
				else if((sq - Math.floor(sq)) == 0 && endpt > 4){
					cur= endpt - 6;
					for( int j = endpt-1; j >= endpt-6; j--) {
						if(occupied[j]) {
							cur = j+1;
							break;
						}
					}
				}
				else {
					find(cur, endpt);
					rule9(cur, endpt);
					int temp = cur;
					cur = endpt;
					if(horizontal == true && vertical == true) {
						for(int x = temp + 1; x <= endpt; x++) {
							if(x%dieroll[i] == 0 && occupied[x]== false) {
								cur= x;
								break;
							}else if(x % dieroll[i] == 0 && occupied[x] == true) {
								cur = temp;
							}
						}
					}
					horizontal = false;
					vertical = false;
				}
			}
			
			if(cur >= 52) {
				System.out.println("GAME OVER");
			}else {
				System.out.println(cur);
			}
		}
		
		
	}
	static void find(int cur, int endpt) {
		for(int j = 0; j < 10; j++) {
			for(int k = 0; k < 10; k++) {
				if(grid[j][k] == cur) {
					curx = j;
					cury= k;
				}
				if(grid[j][k] == endpt) {
					endx = j;
					endy = k;
				}
			}
		}
	}
	
	static void rule9(int cur, int endpt) {
		if(grid[curx][cury] == endpt|| (horizontal && vertical)) {
			return;
		}
		
		if(curx+1 < 10 && grid[curx +1][cury] == cur+1) {
			if(horizontal == true) {
				vertical = true;
			}
			cur = cur+1;
			curx = curx+1;
		}else if(curx-1 >= 0 && grid[curx -1][cury] == cur+1) {
			if(horizontal == true) {
				vertical = true;
			}
			cur = cur+1;
			curx = curx-1;
		}else if(cury +1 <10 && grid[curx][cury+1] == cur +1) {
			horizontal = true;
			cur = cur+1;
			cury = cury+1;
		}else if(cury -1 >= 0 && grid[curx][cury-1] == cur +1) {
			horizontal = true;
			cur = cur+1;
			cury = cury-1;
		}
		rule9(cur, endpt);
	}
	static boolean isPrime(int n) { 
		horizontal= false;
		vertical = false;
	    for(int i=2;i<=Math.sqrt(n);i++) { 
	        if(n%i==0) 
	            return false; 
	    } 
	    return true; 
	}

	
}
