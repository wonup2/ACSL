package Contest4;
/*
* Name: Rachel Lee
* Grade: 11
* Team: ABCobot Intermediate 3
* Contest4
*/

import java.util.*;
import java.io.*;

public class IN_patolli_Rachel {

	
	static Scanner in;
	static String [] temp1, temp2;
	static String corners;
	static int [] input, board, hVCorner, initial;
	static ArrayList<Integer> player, opp, dice;
	static int numRolls, index, temp;
	
	public static void main(String [] args) throws IOException{
		in = new Scanner(new File("1920c4in.in"));
		for(int x = 0; x < 5; x++) {
			try {
				init();
				solve();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	static void init() throws IOException{
		player = new ArrayList<Integer>();
		opp = new ArrayList<Integer>();
		dice = new ArrayList<Integer>();
		temp1 = in.nextLine().split(" ");
		input = new int[temp1.length];
		
		for(int i = 0; i < temp1.length; i++) {
			input[i] = Integer.parseInt(temp1[i]);
		}

		for(int i = 0; i < 3; i++) {
			opp.add(input[i]);
		}
		
		
		for(int i = 3; i < 6; i++) {
			player.add(input[i]);
		}
		Collections.sort(player);
		numRolls = input[6];
		
		for(int i = 7; i < input.length; i++) {
			dice.add(input[i]);
		}
		//System.out.println(dice);
		board = new int[52];
		for(int i = 0; i < 52; i++) {
			board[i] = 0;
		}
		for(int i = 0; i < 3; i++) {
			board[opp.get(i)-1] = 2;
		}
		initial = new int[52];
		for(int i = 0; i < 52; i++) {
			initial[i] = board[i];
		}
		hVCorner = new int[9];
		corners = "7 12 17 22 27 35 40 45 50";
		temp2 = corners.split(" ");
		for(int i = 0; i < hVCorner.length; i++) {
			hVCorner[i] = Integer.parseInt(temp2[i]);
		}
		
	}
	static void solve() {
		for(int i = 0; i < numRolls; i++) {
			for(int j = 0; j < 52; j++) {
				board[j] = initial[j];
			}
			for(int j = 0; j < player.size(); j++) {
				board[player.get(j)-1] = 1;
			}
			int roll = dice.get(i);
			int currPos = player.get(0);
			//System.out.println(roll);
			player.remove(0);
			int lower = currPos;
			if(!occupied(currPos+roll-1)) {
				currPos+=roll;
			}else {
				player.add(currPos);
				Collections.sort(player);
				continue;
			}
			
			int numTrue = 1;
			int count1 = 0;
			boolean applied = false;
			
			while(numTrue>0 && count1<20) {
				count1++;
				numTrue = 0;
				if(currPos == 52) {
					board[51] = 0; 
					break;
				}
				if(isPrime(currPos) == true) {
					applied = true;
					if(currPos+6<=52) {
						int counter = 1;
						boolean move = false;
						
						while(board[currPos + counter - 1] == 0 && counter<6) {
							counter++;
							move = true;
						}
						if(move == true) {
							currPos+=counter-1;
							numTrue++;
						}
					}
				}
				if(onSquare(currPos) == true) {
					applied = true;
					int counter = 1;
					boolean move = false;
					while(board[currPos - counter - 1] == 0 && counter< 6) {
						counter++;
						move = true;
					}
					if(move == true) {
						currPos-=counter-1;
						numTrue++;
					}
				}
				if(!applied) {
					currPos-=roll;
					if(passCorner(lower,currPos+roll)) {
						temp = hVCorner[index];
						currPos = step9(temp,roll,currPos);
						continue;
					}
					currPos+=roll;
				
				}
			}
			player.add(currPos);
			Collections.sort(player);
		}
		for(int i = 0; i < player.size(); i++) {
			if(player.get(i) != 52) {
				System.out.print(player.get(i) + " ");
			}
		}
		System.out.println();
	}
	
	
	public static boolean isPrime(int n){
	    int [] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
	    for (int i=0; i<15; i++){
	      if (n == primes[i])
	        return true;
	    }
	    return false;
	}
	
	static boolean occupied(int n) {
		if(board[n]==0) {
			return false;
		}
		return true;
	}
	static boolean onSquare(int n) {
		int squares[] = {9,16,25,36,49};
		for(int i = 0; i < 5; i++) {
			if(n==squares[i]) {
				return true;
			}
		}
		return false;
	}
	static int step9(int pos, int roll, int initial) {
		for(int i = pos; i <= roll+initial; i++) {
			if(board[i-1] == 0 && i%roll == 0) {
				return i;
			}
		}
		return initial;
	}
	static boolean passCorner(int lower, int upper) {
		for(int i = 0; i < 9; i++) {
			if(lower<hVCorner[i] && upper>hVCorner[i]) {
				index = i;
				return true;
			}
		}
		return false;
	}
}